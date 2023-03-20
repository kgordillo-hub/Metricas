package co.mlforex.forecast.metricas.service;


import co.mlforex.forecast.metricas.model.TransaccionInfo;

public interface ServicioMetricas {

    Boolean calcularMetricas(TransaccionInfo transaccionInfo);

    TransaccionInfo consultarMetricasApp(String idTransaccion);
}
