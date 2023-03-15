package co.mlforex.forecast.repository;

import co.mlforex.forecast.config.DynamoDBConfig;
import co.mlforex.forecast.model.TransaccionInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MetricasInfoImp implements MetricasInfo{

    @Autowired
    DynamoDBConfig dynamoDBConfig;

    @Override
    public void insertarMetricas(TransaccionInfo transaccionInfo) {

    }

    @Override
    public List<TransaccionInfo> consultarMetricas() {
        return null;
    }
}
