package Chofer;

import Chofer.Estados.*;
import Chofer.OfertaDeViaje.*;
import rUBERn.*;

import java.util.Scanner;


public class Chofer {

    // aplicar interfaces de State y saca los boolean

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
        unEstado.working();
    }

    public void terminarViaje(){
        unEstado.goOnline();
        setCoordenadas(viaje.getDestino());
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

    public boolean evaluateOferta2(Viaje viaje){
        OfertaDeViaje oferta = new RechazarOferta(viaje);
        System.out.println("Le ha llegado una solicitud de viaje.¿Que desea hacer?"+"\n"
                +"1. Pedir informacion del viaje"+"\n"
                +"2.Aceptar Viaje"+"\n"
                +"3.Rechazar Viaje");
        Scanner input = new Scanner(System.in);
        int comando = input.nextInt();
        switch (comando){
            case 1:
                System.out.println("------------------"+"\n"
                        +"Punto de encuentro: ("+viaje.getDesde().getX()+","+viaje.getDesde().getY()+")" +"\n"
                        +"Punto de Destino: ("+viaje.getDestino().getX()+","+viaje.getDestino().getY()+")" +"\n"
                        +"Cantidad de personas: "+viaje.getNumberOfPassenger()+"\n"
                        +"------------------");
                evaluateOferta2(viaje);
                break;
            case 2:
                oferta = new AceptarOferta(viaje);
                break;
            case 3:
                break;
            default:
                evaluateOferta2(viaje);
                break;
        }
        return oferta.responderOferta();
    } /**CORREGIR Y HACER TEST, IDEA BIEN PERO NO SALE BIEN DEL LOOP*/

    public void setEstado(Estado estado){
        unEstado=estado;
    }
}