//Alumno: Luis Fernado Prieto Duarte - Meta 2.2 - Event Bus architectural pattern

import eventbus.*;
import components.*;
import java.util.List;

//Main que se encarga de recrear el flujo deseado, en el que el sistema de pedidos
//Recibe un pedido por 1 cerveza y 1 hamburguesa para la mesa 5
//Publicando su pedido realizado, para que luego el event bus reciba el evento
// y notifique a los subscriptores, luego la barra y la cocina realizan y publican
//Los pedidos y el panel led muestra los mensajes, mientras que la banda toca
//Musica en paralelo
public class Main {
    public static void main(String[] args) {
        EventBus bus = new EventBus();
        new Barra(bus);
        new Cocina(bus);
        new SistemaDeSonido(bus);
        new PanelLED(bus);
        new SistemaDeHumo(bus);

        SistemaDePedidos pedidos = new SistemaDePedidos(bus);
        Banda banda = new Banda(bus);

        pedidos.realizarPedido(5, 123, List.of("Cerveza", "Hamburguesa"));
        banda.tocar("Los Seguidores de Dijkstra", "El Algoritmo del Amor", 180);
        banda.tocar("Los Seguidores de Dijkstra", "Through the Fire and Flames", 442);
    }
}
