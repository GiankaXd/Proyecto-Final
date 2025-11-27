
package entidades;

public class Mesas {
    private String numero;
    private String capacidad;

    //contructor con parametros
    public Mesas(String numero, String capacidad){
        this.numero=numero;
        this.capacidad=capacidad;
    }
    

    //metodos set y get
    public String getNumero() {
        return numero;
    }
    public void setNumero (String numero){
        this.numero=numero;
    }
    public String getCapacidad(){
        return capacidad;
    }
    public void setCapacidad (String capacidad){
        this.capacidad=capacidad;
    }
    //metodo reporte
    @Override
    public String toString() {
        return "Numero de mesa: " + numero + ", Capacidad de la mesa: " + capacidad + '}';
    }
}
