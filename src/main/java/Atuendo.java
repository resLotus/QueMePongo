import java.util.List;

public class Atuendo {
    List<Prenda> prendas;

    public Boolean aptaParaTemperatura(int temperatura) {
        return prendas.stream().allMatch(prenda -> prenda.aptaParaTemperatura(temperatura));
    }

    public Boolean aptaParaHumedad(Humedad humedad) {
        return true; // En el futuro abra que agregar el atributo humedad a la prenda
    }
}