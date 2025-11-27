package accesoDatos;

import entidades.Venta;
import java.util.ArrayList;

public class BaseDatosVentas {

    private ArrayList<Venta> listaVentas;   // Colección donde se guardan todas las ventas

    // Constructor
    public BaseDatosVentas() {
        listaVentas = new ArrayList<>();
    }

    // Registrar una venta
    public String registrarVenta(Venta v) {
        listaVentas.add(v);
        return "Venta registrada correctamente";
    }

    // Listar todas las ventas
    public ArrayList<Venta> listarVentas() {
        return listaVentas;
    }

    // Buscar venta por número
    public Venta buscarVenta(String numVenta) {
        for (Venta v : listaVentas) {
            if (v.getNumVenta().equals(numVenta)) {
                return v;
            }
        }
        return null; // no encontrada
    }

    // Eliminar una venta
    public String eliminarVenta(String numVenta) {
        Venta buscada = buscarVenta(numVenta);
        if (buscada != null) {
            listaVentas.remove(buscada);
            return "Venta eliminada";
        }
        return "Venta no encontrada";
    }
}