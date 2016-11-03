
package Chofer.Estados;


import Chofer.Chofer;

public class Online implements Estado{

    public Online(Chofer chofer){
        this.chofer=chofer;
    }

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

    public String toString(){
        return "Online";
    }

}
