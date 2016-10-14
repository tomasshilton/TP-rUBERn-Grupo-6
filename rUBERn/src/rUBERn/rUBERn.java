package rUBERn;


import Chofer.Chofer;
import rUBERn.Gestion;
import java.util.ArrayList;

public class rUBERn{

    private ArrayList<Chofer> choferes;

    public void addChofer(Chofer chofer){
        choferes.add(chofer);
    }

    public void darViajeAChofer(Viaje viaje){
        sortOnline(choferes);

    }


}
