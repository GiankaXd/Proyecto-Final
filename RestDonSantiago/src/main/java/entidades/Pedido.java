package entidades;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    // Atributos del pedido
    private String numeroPedido;        // Número único del pedido
    private Mesas mesa;                 // Mesa asociada al pedido
    private Mozos mozo;                 // Mozo que tomó el pedido
    private ArrayList<Platos> listaPlatos;   // Platos pedidos
    private ArrayList<Bebidas> listaBebidas; // Bebidas pedidas
    private Date hora;                  // Hora del pedido

    // Constructor principal
    public Pedido (String numeroPedido, Mesas mesa, Mozos mozo, Date hora) {
        this.numeroPedido = numeroPedido;
        this.mesa = mesa;
        this.mozo = mozo;
        this.hora = hora;
        this.listaPlatos = new ArrayList<>();
        this.listaBebidas = new ArrayList<>();
    }
    // Métodos para agregar platos y bebidas
    public void agregarPlato(Platos plato){
        listaPlatos.add(plato);
    }

    public void agregarBebida(Bebidas bebida){
        listaBebidas.add(bebida);
    }
    // metodos getters y setters
    public String getNumeroPedido(){ 
        return numeroPedido; 
    }
    public void setNumeroPedido(String numeroPedido){ 
        this.numeroPedido = numeroPedido; 
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

    public ArrayList<Platos> getListaPlatos(){ 
        return listaPlatos; 
    }
    public ArrayList<Bebidas> getListaBebidas(){ 
        return listaBebidas; 
    }

    public Date getHora(){ 
        return hora; 
    }
    public void setHora(Date hora){ 
        this.hora = hora; 
    }
    // Método para calcular el total del pedido
    public double calcularTotal() {
        double total = 0;
        for (Platos p : listaPlatos) {
            total += p.getCantidad() * p.getPrecio();
        }
        for (Bebidas b : listaBebidas) {
            total += b.getCantidad() * b.getPrecio();
        }
        return total;
    }
    // Método reporte
    @Override
    public String toString() {
        return "Pedido N°: " + numeroPedido + "\nMesa: " + mesa.getNumero() + "\nMozo: " + mozo.getNombre() +  "\nTotal: " + calcularTotal();
    }
}
