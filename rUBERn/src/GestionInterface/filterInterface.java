package GestionInterface;

import Chofer.Chofer;
import rUBERn.Viaje;

import java.util.ArrayList;

/**
 * Created by Lucas on 21/10/2016.
 */
public interface FilterInterface {

    public ArrayList<Chofer> filterOnline(ArrayList<Chofer> choferesAEvaluar);

    public ArrayList<Chofer> filterCapacity(Viaje viaje, ArrayList<Chofer> choferesOnline );

    public ArrayList<Chofer> sortByCostoDeImagen(ArrayList<Chofer> choferesConCapacidadYOnline, Viaje viaje);

}
