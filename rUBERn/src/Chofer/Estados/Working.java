
package Chofer.Estados;


import Chofer.Chofer;

public class Working implements Estado{

    private Chofer chofer;

    public Working(Chofer chofer1){
        chofer = chofer1;
    }

    public void goOnline(){
        chofer.setEstado(new Online(chofer));
    }

    public void goOffline(){
        throw new RuntimeException("El chofer no puede irse offline ya que esta trabajando");
    }

    public void working(){}

    public boolean disponible(){
        return false;
    }
}
