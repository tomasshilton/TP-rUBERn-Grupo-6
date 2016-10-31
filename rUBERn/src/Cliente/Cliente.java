package Cliente;

import rUBERn.Viaje;
import rUBERn.Coordenada;

public class Cliente {

    private Viaje viaje;
    private Coordenada posicion;

    public Cliente(Coordenada posicion){
        this.posicion = posicion;
    }

    public Coordenada getPosition() {
        return posicion;
    }

    public void askForTrip(Coordenada destino,int numbersOfPassenger){
        if(viaje==null){
            viaje = new Viaje(posicion, destino,numbersOfPassenger);
        } else throw new ViajeEnProgresoException("El cliente ya se encuentra viajando.");
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void terminarViaje(){
        viaje = null;
    }
}
