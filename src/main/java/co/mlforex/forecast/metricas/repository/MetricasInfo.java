package co.mlforex.forecast.metricas.repository;

import co.mlforex.forecast.metricas.model.TransaccionInfo;
import org.springframework.data.repository.CrudRepository;

public interface MetricasInfo extends CrudRepository<TransaccionInfo, String> {

}
