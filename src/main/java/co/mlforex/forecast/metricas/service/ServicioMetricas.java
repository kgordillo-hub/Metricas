package co.mlforex.forecast.metricas.service;


import co.mlforex.forecast.metricas.model.TransaccionInfo;

import java.util.List;

public interface ServicioMetricas {

    Boolean calcularMetricas(TransaccionInfo transaccionInfo);

    TransaccionInfo consultarMetricasApp(String idTransaccion);

    List<TransaccionInfo> consultarMetricas(String idUsuario);
}
