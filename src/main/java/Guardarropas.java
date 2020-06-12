import java.util.Arrays;
import java.util.List;

public class Guardarropas {
    // Siendo un string se trata más como de un identificador
    // para darle nombre al guardarropas, puede ser de viaje,
    // de entrecasa o de lo que sea
    String categoria;
    List<Prenda> prendasGuardadas;
    List<Modificacion> modificacionesPropuestas;
    List<String> usuariosConAcceso;

    Guardarropas(String categoria, List<String> usuariosConAcceso) {
        this.categoria = categoria;
        this.usuariosConAcceso = usuariosConAcceso;
    }

    public List<Atuendo> todasLasPosiblesCombinaciones() {
        return Arrays.asList(new Atuendo());
    }

    public void agregarPrenda(String usuario, Prenda prenda) {
        if(usuariosConAcceso.contains(usuario)) {
            impactarAgregarPrenda(prenda);
        } else {
            modificacionesPropuestas.add(new AgregarPrenda(prenda));
        }
    }

    public void quitarPrenda(String usuario, Prenda prenda) {
        if(usuariosConAcceso.contains(usuario)) {
            impactarQuitarPrenda(prenda);
        } else {
            modificacionesPropuestas.add(new QuitarPrenda(prenda));
        }
    }

    public void efectivizarModificacion(Modificacion modificacion) {
        modificacionesPropuestas.remove(modificacion);
        modificacion.aplicarEn(this);
    }

    public void impactarAgregarPrenda(Prenda prenda) {
        prendasGuardadas.add(prenda);
    }

    public void impactarQuitarPrenda(Prenda prenda) {
        prendasGuardadas.remove(prenda);
    }
}

interface Modificacion {
    void aplicarEn(Guardarropas guardarropas);

    void revertirModificacion();
}

class AgregarPrenda implements Modificacion {
    Prenda prenda;

    AgregarPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void aplicarEn(Guardarropas guardarropas) {
        guardarropas.impactarAgregarPrenda(prenda);
    }

    @Override
    public void revertirModificacion() {

    }
}

class QuitarPrenda implements Modificacion {
    Prenda prenda;

    QuitarPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void aplicarEn(Guardarropas guardarropas) {
        guardarropas.impactarQuitarPrenda(prenda);
    }
}