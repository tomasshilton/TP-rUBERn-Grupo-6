package Chofer;

import Chofer.Estados.*;
import Chofer.OfertaDeViaje.*;
import rUBERn.*;

import java.util.Scanner;


public class Chofer {



    private Auto choferAuto;
    private Coordenada choferCoordenas;
    private Viaje viaje;
    private Estado unEstado;
    private String id;

    public Chofer(String id,Auto choferAuto, double X, double Y){
        this.choferAuto =choferAuto;
        this.choferCoordenas= new Coordenada(X,Y);
        this.unEstado= new Online(this);
        this.id=id;
    }

    public void setCoordenadas(Coordenada newCoordenadas){
        choferCoordenas=newCoordenadas;
    }

    public Coordenada getChoferCoordenas() {
        return choferCoordenas;
    }

    public void setViaje(Viaje viaje){
        this.viaje=viaje;
        unEstado.working();
    }

    public void terminarViaje(){
        setCoordenadas(viaje.getDestino());
        viaje = null;
        unEstado.goOnline();
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void goOnline(){
        unEstado.goOnline();
    }

    public void goOffline(){
        unEstado.goOffline();
    }

    public boolean disponibilidad(){
        return unEstado.disponible();
    }

    public Estado getUnEstado() {
        return unEstado;
    }

    public Auto getChoferAuto(){
        return choferAuto;
    }

    public boolean evaluateViaje(Viaje viaje){

        int next = 1;
        OfertaDeViaje oferta= new RechazarOferta(viaje);

        while (next == 1){

            oferta.opcionesDeOferta();

            int comando = oferta.elegirOpcionDeOferta();

            if (comando == 1) {
                oferta.pedirInfoDeViaje();
            }
            else if (comando == 2){
                next=2;
                oferta = new AceptarOferta(viaje);
            }else{
                next=3;
            }
        }
        return oferta.responderOferta();
    }

    public String getId() {
        return id;
    }

    public void setEstado(Estado estado){
        unEstado=estado;
    }
}