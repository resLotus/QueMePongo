import java.time.LocalDateTime;
import java.util.List;

public interface ServicioMeteorologico {
    EstadoDelTiempo obtenerCondicionesClimaticas(String direccion);

    List<AlertaMeteorologica> obtenerAlertasMeteorológicas(String direccion);
}
