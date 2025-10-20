//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package componentes;

import busDeEventos.*;

//Publicador que se encarga de notificar cuando se estan preparando las bebias
public class Barra implements EventSubscriber {
    private final EventBus bus;
    public Barra(EventBus bus) {
        this.bus = bus;
        bus.suscribir(PedidoRealizadoEvent.class, this);
    }

    @Override
    public void procesarEvento(Event evento) {
        if (evento instanceof PedidoRealizadoEvent pedido) {
            for (String item : pedido.getItems()) {
                if (item.toLowerCase().contains("cerveza")) {
                    System.out.println("[Barra] Preparando bebida: " + item);
                    new Thread(() -> {
                        //Realizamos un sleep de 2000 milisegundos para lograr que el programa se detenga durante 2 segundos
                        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
                        bus.publicar(new BebidaServidaEvent(pedido.getMesaId(), item));
                    }).start();
                }
            }
        }
    }
}
