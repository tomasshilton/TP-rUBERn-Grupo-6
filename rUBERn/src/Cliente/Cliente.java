package Cliente;
//fffdfd
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
        this.viaje = viaje;
    }

    public askForTrip(Coordenada destino){
        Viaje viaje = new Viaje(posicion, destino);
        this.viaje = viaje;
        newTrip(viaje);
    }
}
