package Chofer;


public class Online extends Estado{

    private Chofer chofer;

    public void goOnline(){}

    public void goOffline(){
        chofer.setEstado(new Offline(chofer));
    }

    public void working(){
        chofer.setEstado(new Working(chofer));
    }

    public boolean disponible(){
        return true;
    }
}
