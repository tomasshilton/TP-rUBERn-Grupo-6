package Chofer.Estados;


import Chofer.Chofer;

public class Offline implements Estado{

    private Chofer chofer;

    public Offline(Chofer chofer1){
        chofer = chofer1;
    }

    public void goOnline(){
        chofer.setEstado(new Online(chofer));
    }

    public void goOffline(){}

    public void working(){
        System.out.println("El chofer no puede trabajar ya que esta offline");
    }

    public boolean disponible(){
        return false;
    }

    public String toString(){
        return "Offline";
    }
}