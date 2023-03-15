package co.mlforex.forecast.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "MetricasInfo")
public class TransaccionInfo implements Serializable {
    //Partition Key
    private String nombreApp;
    private String version;
    private String idUsuario;
    private String idTransaccion;
    //Autogenerado por DB
    private Integer consecutivo;

    //Atributos
    private String [] metricasCalcular;
    private List<Metrica> metricas = new ArrayList<>();

    private List<Double> valoresReales;
    private List<Double> valoresCalculados;

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

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public List<Metrica> getMetricas() {
        return metricas;
    }

    public void setMetricas(List<Metrica> metricas) {
        this.metricas = metricas;
    }

    public List<Double> getValoresReales() {
        return valoresReales;
    }

    public void setValoresReales(List<Double> valoresReales) {
        this.valoresReales = valoresReales;
    }

    public List<Double> getValoresCalculados() {
        return valoresCalculados;
    }

    public void setValoresCalculados(List<Double> valoresCalculados) {
        this.valoresCalculados = valoresCalculados;
    }

    public String[] getMetricasCalcular() {
        return metricasCalcular;
    }

    public void setMetricasCalcular(String[] metricasCalcular) {
        this.metricasCalcular = metricasCalcular;
    }
}
