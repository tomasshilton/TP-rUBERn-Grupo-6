package Chofer.Estados;


import Chofer.Chofer;

public class Online implements Estado{

    private Chofer chofer;

    public void goOnline(){}

    public void goOffline(){

        chofer.setEstado(new Offline());

    }

    public void working(){

        chofer.setEstado(new Working());

    }

    public boolean disponible(){
        return true;
    }

}
