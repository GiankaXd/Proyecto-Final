package accesoDatos;

import entidades.Pedido;
import java.util.ArrayList;

public class BaseDatosPedidos {
    private ArrayList<Pedido> listaPedidos;

    // Constructor
    public BaseDatosPedidos() {
        listaPedidos = new ArrayList<>();
    }

    // Agregar un pedido
    public String agregarPedido(Pedido p) {
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
    public String eliminarPedido(String numero) {
        Pedido p = buscarPedido(numero);
        if (p != null) {
            listaPedidos.remove(p);
            return "Pedido eliminado";
        } else {
            return "Pedido no encontrado";
        }
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
