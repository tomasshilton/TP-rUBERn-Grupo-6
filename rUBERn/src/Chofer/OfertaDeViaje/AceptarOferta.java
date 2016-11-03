package Chofer.OfertaDeViaje;

import rUBERn.Viaje;

/**
 * Created by Lucas on 24/10/2016.
 */
public class AceptarOferta extends OfertaDeViaje{
    public AceptarOferta(Viaje viaje){
        super(viaje);
    }

    public boolean responderOferta(){
        System.out.println("\n"+"Uds ha aceptado la oferta del viaje con destino: ("+viaje.getDestino().getX()+","
                +viaje.getDestino().getY()+")"+"\n"+"Cantidad de pasajeros a transportar: "+viaje.getNumberOfPassenger()+"\n");

        return true;
    }

}
