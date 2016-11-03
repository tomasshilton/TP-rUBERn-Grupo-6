
package Chofer.Estados;


import Chofer.Chofer;

public class Online implements Estado{

    private Chofer chofer;

    public Online(Chofer chofer1){
        chofer = chofer1;
    }

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
