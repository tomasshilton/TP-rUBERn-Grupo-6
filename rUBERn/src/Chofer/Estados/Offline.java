package Chofer.Estados;


import Chofer.Chofer;

public class Offline implements Estado{

    private Chofer chofer;

    public void goOnline(){
        chofer.setEstado(new Online());
    }

    public void goOffline(){}

    public void working(){
        throw new RuntimeException("El chofer no puede trabajar ya que esta offline");
    }

    public boolean disponible(){
        return false;
    }
}