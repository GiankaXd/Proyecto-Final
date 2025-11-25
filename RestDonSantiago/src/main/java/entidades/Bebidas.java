
package entidades;


public class Bebidas {
    private String nombre;
    private int cantidad;
    private double precio;

    //contructor con parametros
    public Bebidas(String nombre, int cantidad, double precio){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    //metodos set y getter
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    //metodo reporte
    @Override
    public String toString() {
        return "Nombre de la bebida: " + nombre + ", Cantidad disponible: " + cantidad + "Precio: " + precio + '}';
    }
}
