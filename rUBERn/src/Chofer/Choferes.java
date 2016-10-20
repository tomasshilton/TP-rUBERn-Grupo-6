package Chofer;

import java.util.ArrayList;

/**
 * Created by Lucas on 12/10/2016.
 */
public class Choferes {
    private ArrayList<Chofer> choferes;

    public Choferes(){
        this.choferes=new ArrayList<>();

    }

    public Chofer getChofer(int index){
        return choferes.get(index);
    }

    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    public void addChofer(Chofer unChofer){
        choferes.add(unChofer);
    }

    public void removeChofer(Chofer unChofer){
        choferes.remove(unChofer);
    }

}
