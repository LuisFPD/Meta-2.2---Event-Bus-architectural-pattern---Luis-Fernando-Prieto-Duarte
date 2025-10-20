//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package busDeEventos;

import java.util.List;


//Evento que tiene que ser inmutable por lo que se utilizan variables final
public class PedidoRealizadoEvent extends Event {
    private final int mesaId;
    private final int pedidoId;
    private final List<String> items;

    public PedidoRealizadoEvent(int mesaId, int pedidoId, List<String> items) {
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = items;
    }

    public int getMesaId() { return mesaId; }
    public int getPedidoId() { return pedidoId; }
    public List<String> getItems() { return items; }
}
