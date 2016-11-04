package rUBERn;

import Chofer.Chofer;

import java.util.ArrayList;


public class Buscador {

    private ArrayList<Chofer> choferes;

    public Buscador(ArrayList<Chofer> choferes){
        this.choferes=choferes;
    }

    public void addChofer(Chofer choferToAdd){
        choferes.add(choferToAdd);
    }

    public void removeChofer(Chofer choferToRemove){
        choferes.remove(choferToRemove);
    }

    public void darViajeAChofer(Viaje viaje){
        ArrayList<Chofer> choferesAEvaluar = choferes;
        ArrayList<Chofer> choferesOnline = filterOnline(choferesAEvaluar);
        ArrayList<Chofer> choferesPosibles = filterCapacity(viaje, choferesOnline);
        ArrayList<Chofer> choferesPosiblesEnDistancia = filterMaxDistance(choferesPosibles, viaje);
        ArrayList<Chofer> choferesPosiblesPorCostoDeImagen = sortByCostoDeImagen(choferesPosiblesEnDistancia, viaje);

        for(Chofer choferATestear:choferesPosiblesPorCostoDeImagen) {
            System.out.println("Chofer "+choferATestear.getId());
            if (choferATestear.evaluateViaje(viaje)) {
                choferATestear.setViaje(viaje);
                return;
            }
        }

        System.out.println("No se encontro chofer a quien darle el viaje");

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

    public ArrayList<Chofer> filterMaxDistance(ArrayList<Chofer> choferesConCapacidadYOnline, Viaje viaje){
        //seteamos la distancia maxima a la que puede estar un chofer del cliente a 15km
        ArrayList<Chofer> choferesEnDistancia = new ArrayList<Chofer>();
        double distanciaMaxima = 15000;
        for(Chofer choferATestear: choferesConCapacidadYOnline){
            if (getDistance(viaje, choferATestear) <= distanciaMaxima){
                choferesEnDistancia.add(choferATestear);
            }
        }
        return choferesEnDistancia;
    }

    public ArrayList<Chofer> sortByCostoDeImagen(ArrayList<Chofer> choferesTrasFiltrado, Viaje viaje) {

        ArrayList<Chofer> choferesPorCostoDeImagen = new ArrayList<Chofer>();

        while (choferesTrasFiltrado.size() > 0){
            Chofer choferConMenorCostoDeImagen = choferesTrasFiltrado.get(0);
            for (Chofer choferATestear : choferesTrasFiltrado) {
                if (compararCostoDeImagen(choferATestear, choferConMenorCostoDeImagen, viaje)) {
                    choferConMenorCostoDeImagen = choferATestear;
                }
            }
            choferesPorCostoDeImagen.add(choferConMenorCostoDeImagen);
            choferesTrasFiltrado.remove(choferConMenorCostoDeImagen);
        }
        return choferesPorCostoDeImagen;

    }

    public double calcularCostoDeImagen(Chofer chofer, Viaje viaje){
        return (getDistance(viaje, chofer)*2)/500 + ((getDistance(viaje, chofer)*2)/500)*(chofer.getChoferAuto().getCategoria().getCostoAdicional() / 100);
    }

    public boolean compararCostoDeImagen(Chofer chofer1, Chofer chofer2, Viaje viaje){
        return (calcularCostoDeImagen(chofer1, viaje) < calcularCostoDeImagen(chofer2, viaje));
    }

    public double getDistance(Viaje viaje, Chofer chofer){
        return (Math.sqrt(Math.pow(viaje.getDesde().getX()-chofer.getChoferCoordenas().getX(),2.0)+Math.pow(viaje.getDesde().getY()-chofer.getChoferCoordenas().getY(),2)));
    }

    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }
}
