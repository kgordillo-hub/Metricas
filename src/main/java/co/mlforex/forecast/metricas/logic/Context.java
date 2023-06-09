package co.mlforex.forecast.metricas.logic;


import co.mlforex.forecast.metricas.model.Metrica;

import java.util.List;

public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public Metrica executeStrategy(List<Double> valoresReales, List<Double> valoresCalculados){
        return strategy.execute(valoresReales, valoresCalculados);
    }
}
