package entidades;

public class DetallePedido {
    private String nomItem;
    private double precioUnitario;
    private int cantidad;

    public DetallePedido(String nomItem, double precioUnitario, int cantidad) {
        this.nomItem = nomItem;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    //Metodos getters y setters
    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //metodo para calcular el subtotal del pedido
    public double getSubtotal(){
        return cantidad * precioUnitario;
    }

    @Override
    public String toString(){
        return"{ Producto: " + nomItem + "\nCantidad: " + cantidad+ "Precio unitario: " +precioUnitario + 
                "\nSubtotal: " + cantidad*precioUnitario + "}";
    } 
}
