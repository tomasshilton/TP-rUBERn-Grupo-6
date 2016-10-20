package rUBERn;

import Chofer.Chofer;

import java.util.ArrayList;
import java.util.Scanner;


public class Gestion {

    private ArrayList<Chofer> choferes;

    public Gestion(ArrayList<Chofer> choferes){
        this.choferes=choferes;
    }

    public void darViajeAChofer(Viaje viaje){
        ArrayList<Chofer> choferesOnline = filterOnline();
        ArrayList<Chofer> choferesPosibles = filterCapacity(viaje, choferesOnline);
        ArrayList<Chofer> choferesPosiblesPorCostoDeImagen = filterByCostoDeImagen(choferesPosibles, viaje);
        int cantidadDeChoferesQueRechazaron = 0;
        for (Chofer choferATestear : choferesPosiblesPorCostoDeImagen){
            if (ofrecerViaje(choferATestear)){
                choferATestear.setViaje(viaje);
                break;
            }
            cantidadDeChoferesQueRechazaron++;
        }
        if (cantidadDeChoferesQueRechazaron == choferesPosiblesPorCostoDeImagen.size()){
            throw new NoHayChoferesException("No hay chofer disponible para este viaje");
        }
    }

    public ArrayList<Chofer> filterOnline(){
        ArrayList<Chofer> choferesOnline = new ArrayList<Chofer>();
        for(Chofer choferATestear: choferes){
            if (choferATestear.disponibilidad()){
                choferesOnline.add(choferATestear);
            }
        }
        return choferesOnline;
    }

    public ArrayList<Chofer> filterCapacity(Viaje viaje, ArrayList<Chofer> choferesOnline ){
        ArrayList<Chofer> choferesConCapacidad = new ArrayList<Chofer>();
        int capacidadATestear = viaje.getNumberOfPassenger();
        for(Chofer choferATestear: choferesOnline){
            if (choferATestear.getChoferAuto().getCapacidad() >= capacidadATestear){
                choferesConCapacidad.add(choferATestear);
            }
        }
        return choferesConCapacidad;
    }

    public ArrayList<Chofer> filterByCostoDeImagen(ArrayList<Chofer> choferesConCapacidadYOnline, Viaje viaje){
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
        return (viaje.getDistance()*2)/500 + ((viaje.getDistance()*2)/500)*(chofer.getChoferAuto().getCategoria().getCostoAdicional() / 100);
    }

    public int compararCostoDeImagen(Chofer chofer1, Chofer chofer2, Viaje viaje){
        if (calcularCostoDeImagen(chofer1, viaje) < calcularCostoDeImagen(chofer2, viaje)){
            return 1;
        } else {
            return 0;
        }
    }

    public boolean ofrecerViaje(Chofer chofer){
        System.out.println("Desea aceptar el viaje? Si o No?");
        Scanner respuesta = new Scanner(System.in);
        if(respuesta.hasNext("Si")){
            return true;
        }
        return false;

    }
}
