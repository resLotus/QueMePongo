import java.time.LocalDateTime;

public interface ServicioMeteorologico {
    EstadoDelTiempo obtenerCondicionesClimaticas(String direccion);
}
