package Chofer;

/**
 * Created by Lucas on 10/10/2016.
 */
public class Chofer {
    private Auto choferAuto;
    private Coordenadas choferCoordenas;

    public Chofer(Auto choferAuto, Coordenadas choferCoordenadas){
        this.choferAuto=choferAuto;
        this.choferCoordenas=choferCoordenadas;
    }

    public void setCoordenadas(Coordenadas newCoordenadas){
        choferCoordenas=newCoordenadas;
    }

}
