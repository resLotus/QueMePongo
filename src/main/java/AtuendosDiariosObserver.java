import java.time.LocalDateTime;
import java.util.List;

public class AtuendosDiariosObserver {
    private LocalDateTime ultimaVezPedidoAtuendoDiario = LocalDateTime.now();
    List<AsesorDeImagen> asesoresDeImagen;

    void actualizarAtuendoDiario(String direccion, Guardarropas guardarropas) {
        if(ultimaVezPedidoAtuendoDiario.plusDays(1).isAfter(LocalDateTime.now()))
            asesoresDeImagen.stream().forEach(asesorDeImagen -> asesorDeImagen.actualizarAtuendoDiario(direccion, guardarropas));

    }

    public void agregarAsesor(AsesorDeImagen asesorDeImagen) {
        asesoresDeImagen.add(asesorDeImagen);
    }

    public void quitarAsesor(AsesorDeImagen asesorDeImagen) {
        asesoresDeImagen.remove(asesorDeImagen);
    }
}
