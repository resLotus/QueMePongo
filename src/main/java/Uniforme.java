public class Uniforme {
    Prenda prendaSuperior;
    Prenda prendaInferior;
    Prenda calzado;

    Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
    }
}

abstract class Sastre {

    public Uniforme fabricarUniforme() {
         return new Uniforme(
                 this.fabricarParteSuperior(),
                 this.fabricarParteInferior(),
                 this.fabricarCalzado());
    }

    // estos método están aquí para ser implementados por las subclases,
    // y no para ser utilizados por otros objetos
    protected abstract Prenda fabricarParteSuperior();

    protected abstract Prenda fabricarParteInferior();

    protected abstract Prenda fabricarCalzado();
}

class SastreSanJuan extends Sastre {
    public Prenda fabricarParteSuperior() {
        Borrador borrador = new Borrador(TipoDePrenda.CHOMBA);
        borrador.especificarColorPrincipal(new Color(1, 1, 1));
        borrador.especificarMaterial(Material.PIQUE);
        return borrador.crearPrenda();
    }

    public Prenda fabricarParteInferior() {
        Borrador borrador = new Borrador(TipoDePrenda.PANTALON);
        borrador.especificarColorPrincipal(new Color(1, 1, 1));
        borrador.especificarMaterial(Material.ACETATO);
        return borrador.crearPrenda();
    }

    public Prenda fabricarCalzado() {
        Borrador borrador = new Borrador(TipoDePrenda.ZAPATO);
        borrador.especificarColorPrincipal(new Color(1, 1, 1));
        return borrador.crearPrenda();
    }
}