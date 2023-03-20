package co.mlforex.forecast.metricas.service;


import co.mlforex.forecast.metricas.logic.Context;
import co.mlforex.forecast.metricas.logic.StrategyMAE;
import co.mlforex.forecast.metricas.logic.StrategyMAPE;
import co.mlforex.forecast.metricas.logic.StrategyRMSE;
import co.mlforex.forecast.metricas.model.Metrica;
import co.mlforex.forecast.metricas.model.TransaccionInfo;
import co.mlforex.forecast.metricas.repository.MetricasInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMetricasImp implements ServicioMetricas {

    @Autowired
    MetricasInfo metricasInfo;

    @Override
    public Boolean calcularMetricas(TransaccionInfo transaccionInfo) {
        final List<String> metricasCalcular = transaccionInfo.getMetricasCalcular();

        if (null != metricasCalcular && metricasCalcular.size() > 0) {
            for (String tipoMetrica : metricasCalcular) {
                final Metrica metrica = calcularMetricaSpec(transaccionInfo.getValoresReales(),
                        transaccionInfo.getValoresCalculados(), tipoMetrica);
                transaccionInfo.getMetricas().add(metrica);
            }
            insertOrUpdate(transaccionInfo);
        }
        return Boolean.TRUE;
    }

    @Override
    public TransaccionInfo consultarMetricasApp(String idTransaccion) {
        return null;
    }

    private Metrica calcularMetricaSpec(List<Double> valoresReales,
                                        List<Double> valoresCalculados, String tipoMetrica) {
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

    private void insertOrUpdate(TransaccionInfo transaccionInfo) {
        //implementar logica
        metricasInfo.save(transaccionInfo);
    }
}
