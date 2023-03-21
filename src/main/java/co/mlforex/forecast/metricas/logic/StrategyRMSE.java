package co.mlforex.forecast.metricas.logic;

import co.mlforex.forecast.metricas.model.Metrica;

import java.util.List;

public class StrategyRMSE implements Strategy{
    @Override
    public Metrica execute(List<Double> datosReales, List<Double> datosCalculados) {
        Metrica metrica = new Metrica();
        metrica.setNombre("RMSE");
        int n = datosReales.size();
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + Math.pow(datosCalculados.get(i) - datosReales.get(i),2);
        }
        double rmse = Math.sqrt(sum / n);

        metrica.setValor(rmse);

        return metrica;
    }
}
