package co.mlforex.forecast.metricas.controller;


import co.mlforex.forecast.metricas.model.TransaccionInfo;
import co.mlforex.forecast.metricas.service.ServicioMetricas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetricasController {

    Logger logger = LoggerFactory.getLogger(MetricasController.class);

    @Autowired
    ServicioMetricas servicioMetricas;
    @PostMapping("/calcularMetricas")
    public ResponseEntity<String> calcularMetricas(@RequestBody TransaccionInfo transaccionInfo){
        try{
            if(servicioMetricas.calcularMetricas(transaccionInfo)){
                return new ResponseEntity<>("Calculated", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
            }
        }catch(final Exception e){
            logger.error("Error en MetricasController:calcularMetricas "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMetricas/{idTransaccion}")
    public ResponseEntity<TransaccionInfo> consultarMetricasApp(@PathVariable String idTransaccion){
        try{
            final TransaccionInfo transaction = servicioMetricas.consultarMetricasApp(idTransaccion);
            if(transaction != null){
                return new ResponseEntity<>(transaction, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }catch(final Exception e){
            logger.error("Error en MetricasController:consultarMetricasApp "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
