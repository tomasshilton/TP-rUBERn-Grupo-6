package Chofer;


public class Auto {

    private String marca;
    private String modelo;
    private int capacidad;
    private Categoria categoria;

    public Auto(String marca, String modelo,int capacidad, Categoria categoria){
        this.marca=marca;
        this.modelo=modelo;
        this.capacidad=capacidad;
        this.categoria = categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
