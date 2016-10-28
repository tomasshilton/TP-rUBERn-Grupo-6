package Chofer;

import Chofer.OfertaDeViaje.AceptarOferta;
import Chofer.OfertaDeViaje.OfertaDeViaje;
import Chofer.OfertaDeViaje.RechazarOferta;
import rUBERn.Viaje;
import rUBERn.Coordenada;

import java.util.Scanner;


public class Chofer {

    // aplicar interfaces de State y saca los boolean

    private Auto choferAuto;
    private boolean trabajando= true;
    private boolean libre = true;
    private Coordenada choferCoordenas;
    private Viaje viaje;
    private String id;
    private Estado unEstado;

    public Chofer(Auto choferAuto, double X, double Y, String id){
        this.choferAuto =choferAuto;
        this.choferCoordenas= new Coordenada(X,Y);
        this.id = id;
    }

    public void setCoordenadas(Coordenada newCoordenadas){
        choferCoordenas=newCoordenadas;
    }

    public Coordenada getChoferCoordenas() {
        return choferCoordenas;
    }

    public void setViaje(Viaje viaje){
        this.viaje=viaje;
        ocupar(); //idea
    }

    public void terminarViaje(){
        setCoordenadas(viaje.getDestino());
        liberar();
        //metodo que pasa al sistema el resumen del viaje terminado
        viaje = null;

    }

    public void finalizarJornada(){
        trabajando=false;
    }

    public String getId() {
        return id;
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

    public boolean evaluateOferta(Viaje viaje){
        /**AGREGAAR LOS DATOS DEL VIAJE PARA CONSOLA*/

        System.out.println("Desea aceptar el viaje?"+"\n"+"1)Aceptar"+" \n"+"2)Rechazar");

        Scanner respuesta = new Scanner(System.in);
        int comando=respuesta.nextInt();
        if(comando == 1){
            setViaje(viaje);
            return true;
        }
        else if(!(comando==2)){
            System.out.println("Ingrese una opcion correcta.");
            evaluateOferta(viaje);
        }
        return false;

    }

    public boolean evaluateOferta2(Viaje viaje){
        OfertaDeViaje oferta;
        System.out.println("A llegagado una solicitud de viaje.¿Que desea hacer?"+"\n"
                +"1. Pedir informacion del viaje"+"\n"
                +"2.Aceptar Viaje"+"\n"
                +"3.Rechazar Viaje");
        Scanner input = new Scanner(System.in);
        int comando = input.nextInt();
        switch (comando){
            case 1:
                System.out.println("Punto de encuentro: ("+viaje.getDesde().getX()+","+viaje.getDesde().getY()+")" +"\n"
                        +"Punto de Destino: ("+viaje.getDestino().getX()+","+viaje.getDestino().getY()+")" +"\n"
                        +"Cantidad de personas: "+viaje.getNumberOfPassenger());
                evaluateOferta2(viaje);
                break;
            case 2:
                oferta = new AceptarOferta(viaje);
                return oferta.responderOferta();
            case 3:
                oferta = new RechazarOferta(viaje);
                return oferta.responderOferta();
            default:
                evaluateOferta2(viaje);
        }
        return false;
    }

}
