package Chofer;


public class CategoriaShilton {

    private String nombre;
    private double costoAdicional;

    public CategoriaShilton(String nombre, double costoAdicional) {
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
