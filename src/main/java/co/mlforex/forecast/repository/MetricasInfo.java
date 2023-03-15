package co.mlforex.forecast.repository;

import co.mlforex.forecast.model.TransaccionInfo;

import java.util.List;

public interface MetricasInfo {

    void insertarMetricas(TransaccionInfo transaccionInfo);

    List<TransaccionInfo> consultarMetricas();
}
