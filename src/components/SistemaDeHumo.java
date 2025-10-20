//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package components;

import eventbus.*;

//Demostración de extensibilidad al agregar una clase que reaccione al caso de que la canción que se encuentre tocando
//sea Through the Fire and Flames" y se encarge de imprimir en consola, que las maquinas de humo se enciendan
public class SistemaDeHumo implements EventSubscriber {
    public SistemaDeHumo(EventBus bus) {
        bus.suscribir(BandaTocandoEvent.class, this);
    }

    @Override
    public void procesarEvento(Event evento) {
        if (evento instanceof BandaTocandoEvent e &&
                e.getNombreCancion().equalsIgnoreCase("Through the Fire and Flames")) {
            System.out.println("[SistemaDeHumo] Efectos de humo activados");
        }
    }
}
