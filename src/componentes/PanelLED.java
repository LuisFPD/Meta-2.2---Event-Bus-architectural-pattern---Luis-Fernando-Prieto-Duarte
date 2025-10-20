//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package componentes;

import busDeEventos.*;

//clase que se subscribe a los eventos e imprime notificaciones en consola
public class PanelLED implements EventSubscriber {
    public PanelLED(EventBus bus) {
        bus.suscribir(BebidaServidaEvent.class, this);
        bus.suscribir(ComidaPreparadaEvent.class, this);
        bus.suscribir(BandaTocandoEvent.class, this);
    }

    @Override
    public void procesarEvento(Event evento) {
        if (evento instanceof BebidaServidaEvent e)
            System.out.println("[PANEL LED] ¡Bebida: " + e.getBebida() + " lista para la mesa " + e.getMesaId() + "!");
        else if (evento instanceof ComidaPreparadaEvent e)
            System.out.println("[PANEL LED] ¡Comida: " + e.getPlato() + " se encuentra lista para el pedido" + e.getPedidoId() + "!");
        else if (evento instanceof BandaTocandoEvent e)
            System.out.println("[PANEL LED]  Tocando la canción: " + e.getNombreCancion() + " por la banda " + e.getNombreBanda());
    }
}
