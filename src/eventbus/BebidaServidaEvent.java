//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package eventbus;

//Evento que tiene que ser inmutable por lo que se utilizan variables final
public class BebidaServidaEvent extends Event {
    private final int mesaId;
    private final String bebida;

    public BebidaServidaEvent(int mesaId, String bebida) {
        this.mesaId = mesaId;
        this.bebida = bebida;
    }

    public int getMesaId() { return mesaId; }
    public String getBebida() { return bebida; }
}
