//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package componentes;

import busDeEventos.*;

//Subscriptor que se subscribe a bandatocandoevent y imprmie un mensaje
public class SistemaDeSonido implements EventSubscriber {
    public SistemaDeSonido(EventBus bus) {
        bus.suscribir(BandaTocandoEvent.class, this);
    }

    @Override
    public void procesarEvento(Event evento) {
        if (evento instanceof BandaTocandoEvent e) {
            System.out.println("[SistemaDeSonido] Ajustando ecualizador para: " + e.getNombreCancion());
        }
    }
}
