package co.mlforex.forecast.metricas.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "MetricasInfo")
public class TransaccionInfo implements Serializable {

    String UID;

    @DynamoDBAttribute
    private String nombreApp;
    @DynamoDBAttribute
    private String version;
    @DynamoDBAttribute
    private String idUsuario;
    @DynamoDBAttribute
    private String idTransaccion;


    @DynamoDBAttribute
    private List<String> metricasCalcular;
    @DynamoDBAttribute
    private List<Metrica> metricas;
    @DynamoDBAttribute
    private String resultado;

    public TransaccionInfo(){

    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public List<String> getMetricasCalcular() {
        return metricasCalcular;
    }

    public void setMetricasCalcular(List<String> metricasCalcular) {
        this.metricasCalcular = metricasCalcular;
    }

    public List<Metrica> getMetricas() {
        return metricas;
    }

    public void setMetricas(List<Metrica> metricas) {
        this.metricas = metricas;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @DynamoDBHashKey(attributeName = "UID")
    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

}
