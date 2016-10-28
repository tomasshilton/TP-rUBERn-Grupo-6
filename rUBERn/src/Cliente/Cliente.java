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



    public Coordenada getPosition() {
        return posicion;
    }

    public void askForTrip(Coordenada destino,int numbersOfPassenger){
        if(viaje==null){
            viaje = new Viaje(posicion, destino,numbersOfPassenger);
        } else throw new ViajeEnProgresoException("El cliente ya se encuentra viajando.");
    }

    public String getId() {
        return id;
    }

    public Viaje getViaje() {
        return viaje;
    }
}
