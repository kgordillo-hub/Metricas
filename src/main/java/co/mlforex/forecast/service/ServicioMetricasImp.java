package co.mlforex.forecast.service;

import co.mlforex.forecast.logic.Context;
import co.mlforex.forecast.logic.StrategyMAE;
import co.mlforex.forecast.logic.StrategyMAPE;
import co.mlforex.forecast.logic.StrategyRMSE;
import co.mlforex.forecast.model.Metrica;
import co.mlforex.forecast.model.TransaccionInfo;
import co.mlforex.forecast.repository.MetricasInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicioMetricasImp implements ServicioMetricas {

    @Autowired
    MetricasInfo metricasInfo;

    @Override
    public Boolean calcularMetricas(TransaccionInfo transaccionInfo) {
        final String[] metricasCalcular = transaccionInfo.getMetricasCalcular();
        if (null != metricasCalcular && metricasCalcular.length > 0) {
            for (String tipoMetrica : metricasCalcular
            ) {
                final Metrica metrica = calcularMetricaSpec(transaccionInfo.getValoresReales(), transaccionInfo.getValoresCalculados(), tipoMetrica);
                transaccionInfo.getMetricas().add(metrica);
            }
            insertOrUpdate(transaccionInfo);
        }
        return Boolean.TRUE;
    }

    @Override
    public List<TransaccionInfo> consultarMetricasApp() {
        return metricasInfo.consultarMetricas();
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

    private void insertOrUpdate(TransaccionInfo transaccionInfo) {
        //implementar logica
        metricasInfo.insertarMetricas(transaccionInfo);
    }
}
