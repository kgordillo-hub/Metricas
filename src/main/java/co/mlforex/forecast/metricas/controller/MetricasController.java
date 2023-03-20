package co.mlforex.forecast.metricas.controller;


import co.mlforex.forecast.metricas.model.TransaccionInfo;
import co.mlforex.forecast.metricas.service.ServicioMetricas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricasController {

    @Autowired
    ServicioMetricas servicioMetricas;
    @PostMapping("/calcularMetricas")
    public ResponseEntity<String> calcularMetricas(TransaccionInfo transaccionInfo){
        if(servicioMetricas.calcularMetricas(transaccionInfo)){
            return new ResponseEntity<>("Calculated", HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<TransaccionInfo> consultarMetricasApp(String idTransaccion){
        final TransaccionInfo listMetrics = servicioMetricas.consultarMetricasApp(idTransaccion);
        return new ResponseEntity<>(listMetrics, HttpStatus.OK);
    }
}
