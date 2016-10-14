package rUBERn;

import Chofer.Chofer;

import Chofer.Choferes;

import java.util.ArrayList;


public class Gestion {

    private ArrayList<Chofer> choferes;

    public void addChofer(Chofer chofer){
        choferes.add(chofer);
    }

    public ArrayList<Chofer> sortOnline(){
        ArrayList<Chofer> choferesOnline = new ArrayList<Chofer>();
        for(Chofer choferATestear: choferes){
            if (choferATestear.disponibilidad()){
                choferesOnline.add(choferATestear);
            }
        }
        return choferesOnline;
    }

    public ArrayList<Chofer> sortCapacity(Viaje viaje,ArrayList<Chofer> choferesOnline ){
        ArrayList<Chofer> choferesConCapacidad = new ArrayList<Chofer>();
        int capacidadATestear = viaje.getNumberOfPassenger();
        for(Chofer choferATestear: choferesOnline){
            if (choferATestear.getChoferAuto().getCapacidad() >= capacidadATestear){
                choferesConCapacidad.add(choferATestear);
            }
        }
        return choferesConCapacidad;
    }

    public ArrayList<Chofer> sortByCostoDeImagen(ArrayList<Chofer> choferesConCapacidadYOnline){
        ArrayList<Chofer> choferesPorCostoDeImagen = new ArrayList<Chofer>();
        for(Chofer choferATestear: choferesConCapacidadYOnline){
            if (choferATestear.getChoferAuto().getCapacidad() >= capacidadATestear){
                choferesConCapacidad.add(choferATestear);
            }
        }
        return choferesConCapacidad;
    }

    public double calcularCostoDeImagen(Chofer chofer, Viaje viaje){
        return (viaje.getDistance()*2)/500 + ((viaje.getDistance()*2)/500)*(chofer.getChoferAuto().getCategoria().getCostoAdicional() / 100)
    }

}
