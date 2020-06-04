import java.time.LocalDateTime;
import java.util.Map;

// Esto es necesario solamente para "agregarle" a las condiciones
// climáticas una expiración
public class RespuestaMeteorologica {
    EstadoDelTiempo estadoDelTiempo;
    LocalDateTime expiracion;

    public RespuestaMeteorologica(EstadoDelTiempo estadoDelTiempo, LocalDateTime expiracion) {
        this.estadoDelTiempo = estadoDelTiempo;
        this.expiracion = expiracion;
    }

    // getters
    public EstadoDelTiempo getEstadoDelTiempo() {
        return estadoDelTiempo;
    }

    // si no fuera por este método en algunos lenguajes
    // bien podría haber sido una tupla
    public boolean expiro() {
        return this.expiracion.isBefore(LocalDateTime.now());
    }
}
