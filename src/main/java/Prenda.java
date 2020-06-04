import java.util.Objects;

public class Prenda {
    TipoDePrenda tipo;
    Material material;
    Trama trama;
    Color color;
    Color colorSecundario;
    int temperaturaMaxima;

    Prenda(TipoDePrenda tipo, Material material, Trama trama, Color color, Color colorSecundario, int temperaturaMaxima) {
        this.tipo = Objects.requireNonNull(tipo, "tipo de prenda es obligatorio");
        this.material = Objects.requireNonNull(material, "material es obligatorio");
        this.trama = Objects.requireNonNull(trama, "trama es obligatorio");
        this.color = Objects.requireNonNull(color, "color es obligatorio");
        this.colorSecundario = colorSecundario;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Boolean aptaParaTemperatura(int temperatura) {
        return temperatura < temperaturaMaxima;
    }
}