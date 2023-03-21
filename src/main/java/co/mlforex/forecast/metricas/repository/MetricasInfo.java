package co.mlforex.forecast.metricas.repository;

import co.mlforex.forecast.metricas.model.TransaccionInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MetricasInfo extends CrudRepository<TransaccionInfo, String> {

}
