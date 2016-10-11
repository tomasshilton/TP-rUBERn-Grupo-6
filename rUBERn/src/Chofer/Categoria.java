package Chofer;


public class Categoria {

    private String nombre;
    private double costoAdicional;

    public Categoria(String nombre, double costoAdicional) {
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

}
