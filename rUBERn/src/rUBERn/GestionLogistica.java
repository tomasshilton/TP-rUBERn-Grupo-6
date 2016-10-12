package rUBERn;

import Chofer.Chofer;

import java.util.ArrayList;

/**
 * Created by Lucas on 12/10/2016.
 */
public class GestionLogistica {
    /**Sin terminar*/
    private ArrayList<Viaje> viajes;

    public GestionLogistica(){
        this.viajes=new ArrayList<>();
    }

    public void addViajes(Viaje unViaje){
        viajes.add(unViaje);
    }
    
    public Viaje sendViaje(Choferes choferes){
        for (int index=0; index<viajes.size(); index++){
            Chofer pedidoChofer = choferes.get(index);
            Viaje viajeARealizar = viajes.get(index);
            int maxPassengers = pedidoChofer.getChoferAuto().getCapacidad();
            if((pedidoChofer.disponibilidad())&&(viajeARealizar.getNumberOfPassenger()<=maxPassengers)){
                /** 1)Pensar alguna forma de darle opcion al Chofer de que acepte o rechaze el viaje
                 *  2)El criterio si esta cerca o lejos, segun coordenada Chofer
                 *  3)
                 */
                pedidoChofer.setViaje(viajeARealizar);
                viajes.remove(viajeARealizar);
                return viajeARealizar;
            }
        }
        throw new NoHayChoferesException("No se encontraron choferes disponible en este momento");
    }

}
