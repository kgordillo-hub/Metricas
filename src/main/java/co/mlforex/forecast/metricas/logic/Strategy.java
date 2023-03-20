package co.mlforex.forecast.metricas.logic;


import co.mlforex.forecast.metricas.model.Metrica;

import java.util.List;

public interface Strategy {

    Metrica execute(List<Double> datosReales, List<Double> datosCalculados);
}
