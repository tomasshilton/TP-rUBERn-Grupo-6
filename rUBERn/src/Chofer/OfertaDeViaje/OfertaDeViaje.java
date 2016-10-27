package Chofer.OfertaDeViaje;
import rUBERn.Viaje;

/**
 * Created by Lucas on 24/10/2016.
 */
public abstract class OfertaDeViaje {
    protected Viaje viaje;

    public OfertaDeViaje(Viaje viaje){
        this.viaje=viaje;
    }

    public abstract boolean responderOferta();

}
