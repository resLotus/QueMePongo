import java.util.Arrays;
import java.util.List;

public class Guardarropas {
    // Siendo un string se trata más como de un identificador
    // para darle nombre al guardarropas, puede ser de viaje,
    // de entrecasa o de lo que sea
    String categoria;
    NivelAcceso nivelAcceso;
    List<Prenda> prendasGuardadas;
    List<Modificacion> prendasPendientes;

    Guardarropas(String categoria, NivelAcceso nivelAcceso) {
        this.categoria = categoria;
        this.nivelAcceso = nivelAcceso.equals(null) ? NivelAcceso.PERSONAL : nivelAcceso;
    }

    public List<Atuendo> todasLasPosiblesCombinaciones() {
        return Arrays.asList(new Atuendo());
    }

    public void agregarPrenda(Prenda prenda) {
        //Quitar modificacion de lista
        prendasGuardadas.add(prenda);
    }

    public void proponerModificacion(Modificacion modificacion) {
        prendasPendientes.add(modificacion);
    }

    public void efectivizarModificación(Modificacion modificacion) {
        prendasPendientes.remove(modificacion);
        agregarPrenda(modificacion.getPrenda());
    }
}

class Modificacion {
    Prenda prenda;
    Operacion operacion;

    Modificacion(Prenda prenda, Operacion operacion) {
        this.prenda = prenda;
        this.operacion = operacion;
    }

    Prenda getPrenda() {
        return prenda;
    }

    Operacion getOperacion() {
        return operacion;
    }
}

enum Operacion {
    AGREGAR, QUITAR
}