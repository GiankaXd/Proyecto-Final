
package accesoDatos;
import entidades.*;
import java.util.*;

public class BaseDatosRegistro {
    //Se declara la coleccion para cada entidad
    private ArrayList<Mozos> mozo;
    private ArrayList<Mesas> mesa;
    private ArrayList<Platos> plato;
    private ArrayList<Bebidas> bebida;

    //Se crea constructor
    public BaseDatosRegistro(){
        //se crea la coleccion 
        mozo = new ArrayList<Mozos>();
        mesa = new ArrayList<Mesas>();
        plato = new ArrayList<Platos>();
        bebida = new ArrayList<Bebidas>();
    }

    //metodo para agregar al ArrayLis y tambien para evitar la duplicacion de DNI
    public String agregarMozo(Mozos M){
        for (Mozos mz : mozo) {
            if (mz.getDNI().equals(M.getDNI())) {
                return "ERROR: Ya existe un mozo con el DNI " + M.getDNI();
            }
        }
        mozo.add(M);
        return "Mozo registrado: " + M.getApellido() + ", " + M.getNombre() + "\nDNI: " + M.getDNI() ;
    }

    //metodo para agregar la mesa yy su capacidad
    public String registrarMesa(Mesas Me){
        mesa.add(Me);
        return "Mesa registrada" + "\n"+ Me.getNumero() + "\nCapacidad: " + Me.getCapacidad() ;
    }
    //metodo para agregar los platos, su cantidad y precios
    public String registrarPlato(Platos p){
        for (Platos pl : plato) {
            if (pl.getNombre().equals(p.getNombre())) {
                return "ERROR: Ya existe un plato con el mismo nombre " + p.getNombre();
            }
        }
        plato.add(p);
        return "Plato registrado" + "\nNombre del plato: "+ p.getNombre() + "\nCantidad: " + p.getCantidad() + "\nPrecio: " + p.getPrecio();
    }
    //metodo para agregar las bebidas, cantidad y precio
    public String registrarBebida(Bebidas b){
        for (Bebidas be : bebida) {
            if (be.getNombre().equals(b.getNombre())) {
                return "ERROR: Ya existe una bebida con el mismo nombre " + b.getNombre();
            }
        }
        bebida.add(b);
        return "Bebida registrada" + "\nNombre de la bebida: "+ b.getNombre() + "\nCantidad: " + b.getCantidad() + "\nPrecio: " + b.getPrecio();
    }
}
