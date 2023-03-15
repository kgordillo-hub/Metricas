package co.mlforex.forecast.logic;

import co.mlforex.forecast.model.Metrica;

import java.util.List;

public class StrategyMAE implements Strategy{
    @Override
    public Metrica execute(List<Double> datosReales, List<Double> datosCalculados) {
        Metrica metrica = new Metrica();
        metrica.setNombre("MAE");
        //Hacer calculo
        metrica.setValor(0.0);
        return metrica;
    }
}
