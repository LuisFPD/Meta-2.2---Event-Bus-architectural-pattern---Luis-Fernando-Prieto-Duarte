//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package busDeEventos;

//Evento que tiene que ser inmutable por lo que se utilizan variables final
public class BandaTocandoEvent extends Event {
    private final String nombreBanda;
    private final String nombreCancion;
    private final int duracion;

    public BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracion) {
        this.nombreBanda = nombreBanda;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getNombreBanda() { return nombreBanda; }
    public String getNombreCancion() { return nombreCancion; }
    public int getDuracion() { return duracion; }
}
