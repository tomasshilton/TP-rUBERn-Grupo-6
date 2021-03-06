package Cliente;

import rUBERn.Viaje;
import rUBERn.Coordenada;

public class Cliente {

    private Viaje viaje;
    private boolean travelling=false;
    private Coordenada posicion;
    private String id;

    public Cliente(Coordenada posicion, String id){
        this.posicion = posicion;
        this.id=id;
    }

    public Coordenada getPosition() {
        return posicion;
    }

    public void askForTrip(Coordenada destino,int numbersOfPassenger){
        if(!(isTravelling())){
            viaje = new Viaje(posicion, destino,numbersOfPassenger);
        } else throw new ViajeEnProgresoException("El cliente ya se encuentra viajando.");
    }

    public Viaje getViaje() {
        return viaje;
    }

    public String getId() {
        return id;
    }

    public boolean isTravelling(){
        return travelling;
    }

    public void travelling(){
        travelling=true;
    }

    public void terminarViaje(){
        posicion=viaje.getDestino();
        viaje = null;
        travelling=false;
    }
}
