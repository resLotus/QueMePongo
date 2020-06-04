import java.util.*;

public class TipoDePrenda {
    Categoria categoria;
    List<Material> materialesAceptados;

    static final TipoDePrenda ZAPATO = new TipoDePrenda(Categoria.CALZADO, Arrays.asList(Material.JEAN));
    static final TipoDePrenda REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON, Material.LANA));
    static final TipoDePrenda REMERA_MANGAS_LARGAS = new TipoDePrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON, Material.LANA));
    static final TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR, Arrays.asList(Material.JEAN, Material.ALGODON));
    static final TipoDePrenda CHOMBA = new TipoDePrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON, Material.PIQUE));

    TipoDePrenda(Categoria categoria, List<Material> materialesAceptados) {
        this.categoria = categoria;
        this.materialesAceptados = materialesAceptados;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean aceptaMaterial(Material material) {
        return materialesAceptados.contains(material);
    }
}

enum Categoria {
    CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIO
}
