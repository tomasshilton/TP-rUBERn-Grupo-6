package Chofer;


public class Online implements Estado{

    private Chofer chofer;

    public void goOnline(){}

    public void goOffline(){

        //chofer.setEstado(new Offline(chofer));

    }

    public void work(){

        //chofer.setEstado(new Working(chofer));

    }

    public boolean disponible(){
        return true;
    }

}
