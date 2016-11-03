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

    public Chofer(Auto choferAuto, double X, double Y){
        this.choferAuto =choferAuto;
        this.choferCoordenas= new Coordenada(X,Y);
        this.unEstado= new Online();
    }

    public void setCoordenadas(Coordenada newCoordenadas){
        choferCoordenas=newCoordenadas;
    }

    public Coordenada getChoferCoordenas() {
        return choferCoordenas;
    }

    public void setViaje(Viaje viaje){
        this.viaje=viaje;
        working();
    }

    public void terminarViaje(){
        goOnline();
        setCoordenadas(viaje.getDestino());
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void goOnline(){
        setEstado(new Online());
    }

    public void goOffline(){
        setEstado(new Offline());
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

    public boolean evaluateOferta(Viaje viaje){

        int next = 1;
        OfertaDeViaje oferta= new RechazarOferta(viaje);

        while (next == 1){
        System.out.println("Le ha llegado una solicitud de viaje.¿Que desea hacer?"+"\n"
                +"1.Pedir informacion del viaje"+"\n"
                +"2.Aceptar Viaje"+"\n"
                +"3.Rechazar Viaje");
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

    public void setEstado(Estado estado){
        unEstado=estado;
    }


    public void working() {
        setEstado(new Working());
    }


    public boolean disponible() {
        return unEstado.disponible();
    }
}
