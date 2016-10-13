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
    }

    public ArrayList<Chofer> sortCapacity(Viaje viaje){
        ArrayList<Chofer> choferesConCapacidad = new ArrayList<Chofer>();
        int capacidadATestear = viaje.getNumberOfPassenger();
        for(Chofer choferATestear: choferes){
            if (choferATestear.getChoferAuto().getCapacidad() >= capacidadATestear){
                choferesConCapacidad.add(choferATestear);
            }
        }
    }



}
