//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package busDeEventos;

//Evento que tiene que ser inmutable por lo que se utilizan variables final
public class ComidaPreparadaEvent extends Event {
    private final int pedidoId;
    private final String plato;

    public ComidaPreparadaEvent(int pedidoId, String plato) {
        this.pedidoId = pedidoId;
        this.plato = plato;
    }

    public int getPedidoId() { return pedidoId; }
    public String getPlato() { return plato; }
}
