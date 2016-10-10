package Chofer;

import rUBERn.Viaje;

/**
 * Created by Lucas on 10/10/2016.
 */
public class Chofer {
    private Auto choferAuto;
    private boolean jornada= true;
    private Coordenadas choferCoordenas;
    private Viaje destino;

    public Chofer(Auto choferAuto, Coordenadas choferCoordenadas){
        this.choferAuto=choferAuto;
        this.choferCoordenas=choferCoordenadas;
    }

    public void setCoordenadas(Coordenadas newCoordenadas){
        choferCoordenas=newCoordenadas;
    }

    public void setDestino(Viaje destino){
        this.destino=destino;
    }

    public void finalizarJordana(){
        this.jornada=false;
    }

    public void iniciarJornada(){
        this.jornada=true;
    }

    public boolean getJornada(){
        return jornada;
    }

}
