//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package componentes;

import busDeEventos.*;

//Publicador que se encarga de avisar cuando se esta preparando algun alimento
public class Cocina implements EventSubscriber {
    private final EventBus bus;

    public Cocina(EventBus bus) {
        this.bus = bus;
        bus.suscribir(PedidoRealizadoEvent.class, this);
    }

    @Override
    public void procesarEvento(Event evento) {
        if (evento instanceof PedidoRealizadoEvent pedido) {
            for (String item : pedido.getItems()) {
                if (item.toLowerCase().contains("hamburguesa")) {
                    System.out.println("[Cocina] Preparando comida: " + item);
                    new Thread(() -> {
                        //Se realiza un sleep durante 5 segundos como se solicita en la entrega
                        try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
                        bus.publicar(new ComidaPreparadaEvent(pedido.getPedidoId(), item));
                    }).start();
                }
            }
        }
    }
}
