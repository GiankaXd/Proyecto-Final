package accesoDatos;

import entidades.Pedido;
import entidades.DetallePedido;
import java.util.ArrayList;

public class BaseDatosPedidos {
    private ArrayList<Pedido> listaPedidos;

    // Constructor
    public BaseDatosPedidos() {
        listaPedidos = new ArrayList<>();
    }

    // Agregar un pedido
    public String agregarPedido(Pedido p) {
        //se valdia si ya existe un pedido con ese número y si es asi, no lo agregamos a la lista de nuevo.
        if (buscarPedido(p.getNumeroPedido()) != null) {
            return "Pedido actualizado correctamente.";
        }
        //si no existe se agrega
        listaPedidos.add(p);
        return "Pedido agregado correctamente";
    }

    // Obtener todos los pedidos
    public ArrayList<Pedido> listarPedidos() {
        return listaPedidos;
    }

    // Buscar un pedido por número
    public Pedido buscarPedido(String numero) {
        for (Pedido p : listaPedidos) {
            if (p.getNumeroPedido().equals(numero)) {
                return p;
            }
        }
        return null; // No encontrado
    }

    // Eliminar un pedido
    public String eliminarPedido (String numero) {
        Pedido p = buscarPedido(numero);
        if (p != null) {
            listaPedidos.remove(p);
        } else {
            // Lanza una excepción si no se encuentra
            throw new IllegalArgumentException("ERROR: Pedido con número " + numero + " no encontrado.");
        }
        return "Pedido eliminado";
    }

    // Actualizar un pedido
    public String actualizarPedido(Pedido pActualizado) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getNumeroPedido().equals(pActualizado.getNumeroPedido())) {
                listaPedidos.set(i, pActualizado);
                return "Pedido actualizado correctamente";
            }
        }
        return "Pedido no encontrado";
    }
}
