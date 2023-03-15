package co.mlforex.forecast.service;

import co.mlforex.forecast.model.Metrica;
import co.mlforex.forecast.model.TransaccionInfo;

import java.util.List;

public interface ServicioMetricas {

    Boolean calcularMetricas(TransaccionInfo transaccionInfo);

    List<TransaccionInfo> consultarMetricasApp();
}
