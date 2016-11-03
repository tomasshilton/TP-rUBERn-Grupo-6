package Chofer.OfertaDeViaje;
import rUBERn.Viaje;

/**
 * Created by Lucas on 25/10/2016.
 */
public class RechazarOferta extends OfertaDeViaje{

    public RechazarOferta(Viaje viaje){
        super(viaje);
    }

    public boolean responderOferta(){
        return false;
    }
}
