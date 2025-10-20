//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package busDeEventos;

//Interfaz encargada de procesar eventos
public interface EventSubscriber {
    void procesarEvento(Event evento);
}
