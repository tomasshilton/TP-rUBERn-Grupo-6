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
        ArrayList<Chofer> choferesAEvaluar = choferes;
        while (choferesAEvaluar.get(0) != null) {
            ArrayList<Chofer> choferesOnline = filterOnline(choferesAEvaluar);
            ArrayList<Chofer> choferesPosibles = filterCapacity(viaje, choferesOnline);
            ArrayList<Chofer> choferesPosiblesPorCostoDeImagen = sortByCostoDeImagen(choferesPosibles, viaje);
            Chofer choferATestear = choferesPosiblesPorCostoDeImagen.get(0);
            if (ofrecerViaje(choferATestear)) {
                choferATestear.setViaje(viaje);
                break;
            } else {
                choferesAEvaluar.remove(choferATestear);
            }
        }
        if (choferesAEvaluar.get(0) == null) {
            throw new NoHayChoferesException("No hay chofer disponible para este viaje");
        }
    }

    public ArrayList<Chofer> filterOnline(ArrayList<Chofer> choferesAEvaluar){
        ArrayList<Chofer> choferesOnline = new ArrayList<Chofer>();
        for(Chofer choferATestear: choferesAEvaluar){
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

    public ArrayList<Chofer> sortByCostoDeImagen(ArrayList<Chofer> choferesConCapacidadYOnline, Viaje viaje){
        ArrayList<Chofer> ret = new ArrayList<>();
        Chofer next;
        for(Chofer c:choferesConCapacidadYOnline){
            next = choferesConCapacidadYOnline.get(choferesConCapacidadYOnline.indexOf(c)+1);
            if(calcularCostoDeImagen(c,viaje)>calcularCostoDeImagen(next,viaje)){
                ret.add(choferesConCapacidadYOnline.indexOf(c)+1,c);
                ret.add(choferesConCapacidadYOnline.indexOf(c),next);
            }

        }
        return ret;


















       /* ArrayList<Chofer> choferesPorCostoDeImagen = new ArrayList<Chofer>();
        Chofer choferConMenorCostoDeImagen = choferesConCapacidadYOnline.get(0);
        while (choferesConCapacidadYOnline.get(0)!=null){
            for (Chofer choferATestear : choferesConCapacidadYOnline) {
                if (compararCostoDeImagen(choferATestear, choferConMenorCostoDeImagen, viaje) == 1) {
                    choferConMenorCostoDeImagen = choferATestear;
                }
            }
            choferesPorCostoDeImagen.add(choferConMenorCostoDeImagen);
            choferesConCapacidadYOnline.remove(choferConMenorCostoDeImagen);
        }
        return choferesPorCostoDeImagen;
        */
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

    private boolean ofrecerViaje(Chofer chofer){
        System.out.println("Desea aceptar el viaje? Si o No?");
        Scanner respuesta = new Scanner(System.in);
        if(respuesta.hasNext("Si")){
            return true;
        }
        return false;

    }
}
