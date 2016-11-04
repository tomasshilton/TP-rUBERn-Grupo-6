
package Chofer.Estados;


import Chofer.Chofer;

public class Working implements Estado{

    private Chofer chofer;

    public Working(Chofer chofer1){
        chofer = chofer1;
    }

    public void goOnline(){
        if(chofer.getViaje() == null){
            chofer.setEstado(new Online(chofer));
        }else{
            System.out.println("El chofer esta viajando");
        }
    }

    public void goOffline(){
        System.out.println("El chofer no puede irse offline ya que esta trabajando");
    }

    public void working(){}

    public boolean disponible(){
        return false;
    }

    public String toString(){
        return "Working";
    }
}
