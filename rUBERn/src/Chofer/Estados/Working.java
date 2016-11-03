
package Chofer.Estados;


import Chofer.Chofer;

public class Working implements Estado{
    private Chofer chofer;

    public void goOnline(){
        chofer.setEstado(new Online());
    }

    public void goOffline(){
        throw new RuntimeException("El chofer no puede irse offline ya que esta trabajando");
    }

    public void working(){}

    public boolean disponible(){
        return false;
    }
}
