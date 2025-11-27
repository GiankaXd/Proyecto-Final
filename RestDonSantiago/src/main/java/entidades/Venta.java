
package entidades;
import java.time.LocalDateTime;
public class Venta {
    private String numVenta;
    private Pedido pedido;
    private LocalDateTime fecha;
    private double total;

    public Venta(String numVenta, Pedido pedido, LocalDateTime fecha, double total) {
        this.numVenta = numVenta;
        this.pedido = pedido;
        this.fecha = fecha;
        this.total = pedido.getcalcularTotal();
    }
    
    //metodos getters y setters
    public String getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(String numVenta) {
        this.numVenta = numVenta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        this.total = pedido.getcalcularTotal();
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    //
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString(){
    return "{ Venta N°: " + numVenta + "\nFecha: " + fecha + "\nPedido: " + pedido + "\nTotal: " + total + "}";
    }
}
