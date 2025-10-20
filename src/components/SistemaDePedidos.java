//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package components;

import eventbus.*;
import java.util.List;

//Publicador que regresa en texto una notificacion referente a un nuevo pedido
public class SistemaDePedidos {
    private final EventBus bus;

    public SistemaDePedidos(EventBus bus) {
        this.bus = bus;
    }

    public void realizarPedido(int mesaId, int pedidoId, List<String> items) {
        System.out.println("[SistemaDePedidos] Pedido recibido de mesa " + mesaId);
        bus.publicar(new PedidoRealizadoEvent(mesaId, pedidoId, items));
    }
}
