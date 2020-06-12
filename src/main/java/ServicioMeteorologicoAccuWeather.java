import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
    AccuWeatherAPI api;
    Duration periodoDeValidez;
    private Map<String, RespuestaMeteorologica> ultimasRespuestas;

    public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
        this.api = api;
        this.periodoDeValidez = periodoDeValidez;
        this.ultimasRespuestas = new HashMap<String, RespuestaMeteorologica>();
    }

    // esto es un algoritmo clásico de caché:
    //     * si no está en caché o está expirada, recalcular y guardar.
    //     * en cualquier caso: devolver el resultado de la caché
    public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
        if (!this.ultimasRespuestas.containsKey(direccion) || this.ultimasRespuestas.get(direccion).expiro()) {
            ultimasRespuestas.put(direccion, new RespuestaMeteorologica(this.consultarApi(direccion), proximaExpiracion()));
        }
        return this.ultimasRespuestas.get(direccion).getEstadoDelTiempo();
    }

    private LocalDateTime proximaExpiracion() {
        return LocalDateTime.now().plus(this.periodoDeValidez);
    }

    private EstadoDelTiempo consultarApi(String direccion) {
        // Encapsulamos el problema
        // ¿Podríamos haber usado algún patron creacional?
        // Quizás, pero no sentí que aportara nada acá.
        Map<String, Object> respuesta = this.api.getWeather(direccion).get(0);
        int temperatura = (int) ((Map) respuesta.get("Temperature")).get("Value");
        Humedad humedad = (double) respuesta.get("PrecipitationProbability") > 0.8 ? Humedad.LLUVIOSO : Humedad.SECO;
        AlertaMeteorologica alertaMeteorologica = pasarAEspaniol((String) respuesta.get("CurrentAlerts"));
        return new EstadoDelTiempo(temperatura, humedad, alertaMeteorologica);
    }

    private AlertaMeteorologica pasarAEspaniol(String alerta) {
        if(alerta.equals("storm"))
            return AlertaMeteorologica.TORMENTA;
        else if(alerta.equals("ice"))
            return AlertaMeteorologica.GRANIZO;
    }
}
