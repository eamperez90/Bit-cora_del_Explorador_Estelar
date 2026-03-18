import java.util.ArrayList;
import java.util.List;

class BitacoraStack {
    private final List<String> eventos;

    public BitacoraStack() {
        this.eventos = new ArrayList<>();
    }

    public void registrar(String evento) {
        if (evento == null) {
            throw new IllegalArgumentException("El evento no puede ser null.");
        }
        eventos.add(evento);
    }

    public String consultarUltimo() {
        if (estaVacia()) {
            throw new RuntimeException("No se puede consultar: la bitácora está vacía.");
        }
        return eventos.get(eventos.size() - 1);
    }

    public String eliminarUltimo() {
        if (estaVacia()) {
            throw new RuntimeException("No se puede eliminar: la bitácora está vacía.");
        }
        return eventos.remove(eventos.size() - 1);
    }

    public boolean estaVacia() {
        return eventos.isEmpty();
    }

    public int totalEventos() {
        return eventos.size();
    }
}

public class Main {
    public static void main(String[] args) {
        BitacoraStack bitacora = new BitacoraStack();

        bitacora.registrar("Motor de estribor encendido");
        bitacora.registrar("Velocidad warp alcanzada");
        bitacora.registrar("Señal de comunicación estable");
        bitacora.registrar("Anomalía detectada en sector 7");
        bitacora.registrar("Escudos al 40%");
        bitacora.registrar("ERROR CRÍTICO: fallo en sistema de navegación");

        String ultimo = bitacora.consultarUltimo();
        System.out.println("Último evento registrado: " + ultimo);

        if (ultimo.contains("ERROR")) {
            System.out.println("\nProtocolo de revisión activado:");
            for (int i = 0; i < 3; i++) {
                System.out.println("Evento removido: " + bitacora.eliminarUltimo());
            }
        }

        System.out.println("\nEstado actual de la bitácora:");
        System.out.println("Total de eventos restantes: " + bitacora.totalEventos());

        if (!bitacora.estaVacia()) {
            System.out.println("Evento en la cima: " + bitacora.consultarUltimo());
        }

        /*
         * Una pila es ideal porque funciona con LIFO (último en entrar, primero en salir),
         * lo que permite revisar rápidamente el evento más reciente.
         * Si se usara una lista por índices, se podría acceder a cualquier posición,
         * rompiendo el control del orden y aumentando errores en el manejo de eventos.
         */
    }
}
