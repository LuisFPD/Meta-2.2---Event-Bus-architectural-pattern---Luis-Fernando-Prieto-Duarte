//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package components;

import eventbus.*;

//Publicador que se encarga de generar un bandatocandoevent simulando tocar durante x segundos
public class Banda {
    private final EventBus bus;

    public Banda(EventBus bus) {
        this.bus = bus;
    }

    public void tocar(String nombreBanda, String cancion, int duracion) {
        System.out.println("[Banda] Tocando: " + cancion);
        bus.publicar(new BandaTocandoEvent(nombreBanda, cancion, duracion));
    }
}
