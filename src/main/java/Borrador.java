import java.util.Objects;

public class Borrador {
    TipoDePrenda tipo;
    Material material;
    Trama trama = Trama.LISA;
    Color color;
    Color colorSecundario = null;
    int temperaturaMaxima;

    Borrador(TipoDePrenda tipo) {
        this.tipo = Objects.requireNonNull(tipo, "tipo de prenda es obligatorio");
    }

    public void especificarMaterial(Material material) {
        if (!tipo.aceptaMaterial(material))
            throw new MaterialException("Este tipo de prenda no acepta este material");
        this.material = material;
    }

    public void especificarTrama(Trama trama) {
        this.trama = trama.equals(null) ? Trama.LISA : trama;
    }

    public void especificarColorPrincipal(Color colorPrincipal) {
        this.color = Objects.requireNonNull(colorPrincipal, "colorPrincipal de prenda es obligatorio");
    }

    public void especificarColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public void especificarTemperaturaMaxima(int temperaturaMaxima) { this.temperaturaMaxima = temperaturaMaxima;}

    public Prenda crearPrenda() {
        return new Prenda(tipo, material, trama, color, colorSecundario, temperaturaMaxima);
    }
}