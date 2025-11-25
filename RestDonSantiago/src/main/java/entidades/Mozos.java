package entidades;

public class Mozos {
    private String Apellido;
    private String Nombre;
    private String DNI;
    
    //variable para contador de la cantida de mozos
    private static int nMozo=0;
    
    //constructor con parametros
    public Mozos( String Apellido, String Nombre, String DNI){
        nMozo++;
        this.DNI= DNI;
        this.Apellido=Apellido;
        this.Nombre=Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    //metodo reporte
    @Override
    public String toString() {
        return "Mozo{" + "Apellido=" + Apellido + ", Nombre=" + Nombre + ", DNI:" + DNI+ '}';
    }
}
