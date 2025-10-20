//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package busDeEventos;

//Clase abstracta que se encarga de guardar el tiempo en milisegundos de los eventos.
public abstract class Event {
    private final long tiempo = System.currentTimeMillis();

    public long getTimestamp() {
        return tiempo;
    }
}
