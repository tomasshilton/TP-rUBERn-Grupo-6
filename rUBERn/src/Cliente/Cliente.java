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

    public void setViaje(Viaje viaje) {
        if(viaje.equals(null))
            this.viaje = viaje;
        else
            throw new ViajeEnProgresoException("Uds. todavia se encuentra en viaje a su destino ("+posicion.getX()+","+posicion.getY()+")"+
                    "\n"+". Una vez finalizado puede pedir uno nuevamente");
    }

    public void askForTrip(Coordenada destino,int numbersOfPassenger){
        Viaje viaje = new Viaje(posicion, destino,numbersOfPassenger);
        this.viaje = viaje;
    }

    public void askForTrip(Coordenada destino){
        askForTrip(destino, 1);
    }

    public void setPosition(Coordenada posicion) {
        this.posicion = posicion;
    }


}
