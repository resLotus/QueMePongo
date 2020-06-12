public class EstadoDelTiempo {
    int temperatura;
    Humedad humedad;
    AlertaMeteorologica alertaMeteorologica;

    public EstadoDelTiempo(int temperatura, Humedad humedad, AlertaMeteorologica alertaMeteorologica) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.alertaMeteorologica = alertaMeteorologica;
    }
}
