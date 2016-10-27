package Cliente;

import rUBERn.Viaje;
import rUBERn.Coordenada;

public class Cliente {

    private Viaje viaje;
    private Coordenada posicion;
    private String id;

    public Cliente(String insertID, Coordenada posicion){
        this.posicion = posicion;
        this.id=insertID;

    }

    public Viaje getViaje() {
        return viaje;
    }

    public Coordenada getPosition() {
        return posicion;
    }

    public void askForTrip(Coordenada destino,int numbersOfPassenger){
        viaje = new Viaje(posicion, destino,numbersOfPassenger);
    }

    public void askForTripForOnePerson(Coordenada destino){
        askForTrip(destino, 1);
    }

    public void setPosition(Coordenada posicion) {
        this.posicion = posicion;
    }

    public String getId() {
        return id;
    }
}
