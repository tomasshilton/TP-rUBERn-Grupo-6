package Chofer;


public class Auto {

    private String marca;
    private String modelo;
    private int capacidad;

    public Auto(String marca, String modelo,int capacidad){
        this.marca=marca;
        this.modelo=modelo;
        this.capacidad=capacidad;
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
}
