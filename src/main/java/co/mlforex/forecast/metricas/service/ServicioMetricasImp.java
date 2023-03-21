package co.mlforex.forecast.metricas.service;


import co.mlforex.forecast.metricas.logic.Context;
import co.mlforex.forecast.metricas.logic.StrategyMAE;
import co.mlforex.forecast.metricas.logic.StrategyMAPE;
import co.mlforex.forecast.metricas.logic.StrategyRMSE;
import co.mlforex.forecast.metricas.model.Metrica;
import co.mlforex.forecast.metricas.model.TransaccionInfo;
import co.mlforex.forecast.metricas.repository.MetricasInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMetricasImp implements ServicioMetricas {

    @Autowired
    MetricasInfo metricasInfo;

    @Override
    public Boolean calcularMetricas(TransaccionInfo transaccionInfo) {
        final List<String> metricasCalcular = transaccionInfo.getMetricasCalcular();
        final String resultadoB64 = transaccionInfo.getResultado();
        final List<Double> valoresReales = getValores(resultadoB64, "Real_values");
        final List<Double> valoresPredichos = getValores(resultadoB64, "Predicted_values");


        if (null != metricasCalcular && metricasCalcular.size() > 0 && !valoresReales.isEmpty() && !valoresPredichos.isEmpty()) {
            transaccionInfo.setMetricas(new ArrayList<>());
            for (String tipoMetrica : metricasCalcular) {
                final Metrica metrica = calcularMetricaSpec(valoresReales, valoresPredichos, tipoMetrica);
                transaccionInfo.getMetricas().add(metrica);
            }
            transaccionInfo.setUID(transaccionInfo.getIdTransaccion());
            metricasInfo.save(transaccionInfo);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private List<Double> getValores(String resultadoB64, String property) {
        final List<Double> listValues = new ArrayList<>();
        if (resultadoB64 != null && !resultadoB64.isEmpty()) {
            final String resultadoJson = new String(Base64.getDecoder().decode(resultadoB64));
            final JsonObject jsonObject = new JsonParser().parse(resultadoJson).getAsJsonObject();
            final List<JsonElement> jsonElements = jsonObject.get(property).getAsJsonArray().asList();
            for (final JsonElement jsonElement : jsonElements) {
                listValues.add(jsonElement.getAsDouble());
            }
        }
        return listValues;
    }

    @Override
    public TransaccionInfo consultarMetricasApp(String idTransaccion) {
        final Optional<TransaccionInfo> transaccionInfoOp = metricasInfo.findById(idTransaccion);
        return transaccionInfoOp.get();
    }

    private Metrica calcularMetricaSpec(List<Double> valoresReales, List<Double> valoresCalculados, String tipoMetrica) {
        final Context contexto = new Context();

        if (tipoMetrica.toUpperCase().equalsIgnoreCase("MAE")) {
            contexto.setStrategy(new StrategyMAE());
        } else if (tipoMetrica.toUpperCase().equalsIgnoreCase("MAPE")) {
            contexto.setStrategy(new StrategyMAPE());
        } else if (tipoMetrica.toUpperCase().equalsIgnoreCase("RMSE")) {
            contexto.setStrategy(new StrategyRMSE());
        } else {
            return null;
        }
        return contexto.executeStrategy(valoresReales, valoresCalculados);
    }

}
