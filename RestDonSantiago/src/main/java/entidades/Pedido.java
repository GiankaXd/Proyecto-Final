package entidades;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    // Atributos del pedido
    private String numPedido;        // Número único del pedido
    private Mesas mesa;                 // Mesa asociada al pedido
    private Mozos mozo;   
    private String estado;// Mozo que tomó el pedido
    
    //se inicializan las listas vacias al crear el pedido
    private ArrayList<DetallePedido> detalles;   // Detalle del pedido
    private Date hora;                  // Hora del pedido

    // Constructor principal
    public Pedido (String numPedido, Mesas mesa, Mozos mozo, Date hora) {
        this.numPedido = numPedido;
        this.mesa = mesa;
        this.mozo = mozo;
        this.estado = "ACTIVO";
        this.hora = hora;
        this.detalles = new ArrayList<>();
    }
    // Métodos para agregar platos y bebidas
    public void agregarDetalle(DetallePedido det){
        detalles.add(det);
    }

    // metodos getters y setters
    public String getNumeroPedido(){ 
        return numPedido; 
    }
    public void setNumeroPedido(String numeroPedido){ 
        this.numPedido = numPedido; 
    }

    public Mesas getMesa(){ 
        return mesa; 
    }
    public void setMesa(Mesas mesa){ 
        this.mesa = mesa; 
    }

    public Mozos getMozo() { 
        return mozo; 
    }
    public void setMozo(Mozos mozo){ 
        this.mozo = mozo; 
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<DetallePedido> getDetalles(){ 
        return detalles; 
    }


    public Date getHora(){ 
        return hora; 
    }
    public void setHora(Date hora){ 
        this.hora = hora; 
    }
    // Método para calcular el total del pedido
    public double getcalcularTotal() {
        double total = 0;
        //recorre la lista de peidos
        for (DetallePedido det : detalles) {
            total += det.getSubtotal();
        }
        return total;
    }
    // Método reporte
    @Override
    public String toString() {
        return "Pedido N°: " + numPedido + "\nMesa: " + mesa.getNumero() + 
                "\nMozo: " + mozo.getNombre() +  "\nTotal: " + getcalcularTotal();
    }
}
