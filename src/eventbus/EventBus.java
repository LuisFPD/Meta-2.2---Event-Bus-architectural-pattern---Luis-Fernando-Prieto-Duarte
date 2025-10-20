//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern
package eventbus;

import java.util.*;

public class EventBus {
    private final Map<Class<?>, List<EventSubscriber>> subscribers = new HashMap<>();

    //Registra la funcion o objeto que se quiere notificar
    public <T extends Event> void suscribir(Class<T> tipoEvento, EventSubscriber suscriptor) {
        subscribers.computeIfAbsent(tipoEvento, k -> new ArrayList<>()).add(suscriptor);
    }

    //Remueve a un subscriptor
    public <T extends Event> void desuscribir(Class<T> tipoEvento, EventSubscriber suscriptor) {
        List<EventSubscriber> lista = subscribers.get(tipoEvento);
        if (lista != null) lista.remove(suscriptor);
    }

    //Toma un objeto de un evento y lo notifica a todos los subscritos a ese evento
    public void publicar(Event evento) {
        List<EventSubscriber> lista = subscribers.getOrDefault(evento.getClass(), Collections.emptyList());
        for (EventSubscriber s : lista) {
            s.procesarEvento(evento);
        }
    }
}
