package co.mlforex.forecast.controller;

import co.mlforex.forecast.model.TransaccionInfo;
import co.mlforex.forecast.service.ServicioMetricas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    public ResponseEntity<List<TransaccionInfo>> consultarMetricasApp(){
        final List<TransaccionInfo> listMetrics = servicioMetricas.consultarMetricasApp();
        return new ResponseEntity<>(listMetrics, HttpStatus.OK);
    }
}
