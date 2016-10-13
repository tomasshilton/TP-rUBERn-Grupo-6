package Cliente;

import rUBERn.Viaje;
import rUBERn.Coordenada;

public class Cliente {

    private Viaje viaje;
    private Coordenada posicion;



    public Cliente(Coordenada posicion){
        this.posicion = posicion;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public Coordenada getPosicion() {
        return posicion;
    }

    public void setViaje(Viaje viaje) {
        if(viaje.equals(null))
            this.viaje = viaje;
        else
            throw new ViajeEnProgresoException("Uds. todavia se encuentra en viaje a su destino ("+posicion.getX()+","+posicion.getY()+")"+
                    "\n"+". Una vez finalizado puede pedir uno nuevamente");
    }

    public void askForTrip(Coordenada destino){
        Viaje viaje = new Viaje(posicion, destino);
        this.viaje = viaje;
    }

    public void setPosicion(Coordenada posicion) {
        this.posicion = posicion;
    }
}
