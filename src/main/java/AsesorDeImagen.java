import java.util.List;
import java.util.stream.Collectors;

public class AsesorDeImagen {
    private ServicioMeteorologico servicioMeteorologico;

    // .... constructor que inyecta al servicio meteorologico....
    public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico) {
        this.servicioMeteorologico = servicioMeteorologico;
    }

    public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarropas) {
        EstadoDelTiempo estadoDelTiempo = this.servicioMeteorologico.obtenerCondicionesClimaticas(direccion);

        List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones();

        return combinaciones.stream()
                .filter(combinacion -> combinacion.aptaParaTemperatura(estadoDelTiempo.temperatura))
                .filter(combinacion -> combinacion.aptaParaHumedad(estadoDelTiempo.humedad))
                .collect(Collectors.toList()).get(0);
    }
}
