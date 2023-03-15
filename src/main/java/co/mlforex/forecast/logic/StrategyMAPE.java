package co.mlforex.forecast.logic;

import co.mlforex.forecast.model.Metrica;

import java.util.List;

public class StrategyMAPE implements Strategy{
    @Override
    public Metrica execute(List<Double> datosReales, List<Double> datosCalculados) {
        Metrica metrica = new Metrica();
        metrica.setNombre("MAPE");
        //Hacer calculo
        metrica.setValor(0.0);
        return metrica;
    }
}
