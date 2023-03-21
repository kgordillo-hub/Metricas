package co.mlforex.forecast.metricas.logic;

import co.mlforex.forecast.metricas.model.Metrica;

import java.util.List;

public class StrategyMAE implements Strategy {
    @Override
    public Metrica execute(List<Double> datosReales, List<Double> datosCalculados) {
        Metrica metrica = new Metrica();
        metrica.setNombre("MAE");
        int n = datosReales.size();
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + Math.abs(datosReales.get(i) - datosCalculados.get(i));
        }
        double mae = sum / n;

        metrica.setValor(mae);
        return metrica;
    }
}
