package co.mlforex.forecast.logic;

import co.mlforex.forecast.model.Metrica;

import java.util.List;

public interface Strategy {

    Metrica execute(List<Double> datosReales, List<Double> datosCalculados);
}
