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

    public ArrayList<Chofer> sortByCostoDeImagen(ArrayList<Chofer> choferesConCapacidadYOnline, Viaje viaje){
        ArrayList<Chofer> choferesPorCostoDeImagen = new ArrayList<Chofer>();
        Chofer choferConMenorCostoDeImagen = choferesConCapacidadYOnline.get(0);
        while (choferesConCapacidadYOnline.size() > 0) {
            for (Chofer choferATestear : choferesConCapacidadYOnline) {
                if (compararCostoDeImagen(choferATestear, choferConMenorCostoDeImagen, viaje) == 1) {
                    choferConMenorCostoDeImagen = choferATestear;
                }
            }
            choferesPorCostoDeImagen.add(choferConMenorCostoDeImagen);
            choferesConCapacidadYOnline.remove(choferConMenorCostoDeImagen);
        }
        return choferesPorCostoDeImagen;
    }

    public double calcularCostoDeImagen(Chofer chofer, Viaje viaje){
        return (viaje.getDistance()*2)/500 + ((viaje.getDistance()*2)/500)*(chofer.getChoferAuto().getCategoria().getCostoAdicional() / 100)
    }

    public int compararCostoDeImagen(Chofer chofer1, Chofer chofer2, Viaje viaje){
        if (calcularCostoDeImagen(chofer1, viaje) < calcularCostoDeImagen(chofer2, viaje)){
            return 1;
        } else {
            return 0;
        }
    }
}
