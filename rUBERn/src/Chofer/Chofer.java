package Chofer;

import rUBERn.Viaje;
import rUBERn.Coordenada;


public class Chofer {

    private Auto choferAuto;
    private boolean trabajando= true;
    private boolean libre = true;
    private Coordenada choferCoordenas;
    private Viaje viaje;

    public Chofer(Auto choferAuto, Coordenada choferCoordenadas){
        this.choferAuto=choferAuto;
        this.choferCoordenas=choferCoordenadas;
    }

    public void setCoordenadas(Coordenada newCoordenadas){
        choferCoordenas=newCoordenadas;
    }

    public void setViaje(Viaje viaje){
        this.viaje=viaje;
    }

    public void finalizarJordana(){
        trabajando=false;
    }

    public void iniciarJornada(){
        trabajando=true;
    }

    public void liberar(){
        libre = true;
    }

    public void ocupar(){
        libre = false;
    }

    public boolean disponibilidad(){
        return libre && trabajando;
    }

    public Auto getChoferAuto(){
        return choferAuto;
    }

}
