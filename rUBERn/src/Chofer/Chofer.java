package Chofer;

import Chofer.Estados.Estado;
import Chofer.Estados.Online;
import Chofer.Estados.Working;
import Chofer.OfertaDeViaje.AceptarOferta;
import Chofer.OfertaDeViaje.OfertaDeViaje;
import Chofer.OfertaDeViaje.RechazarOferta;
import rUBERn.Viaje;
import rUBERn.Coordenada;

import java.util.Scanner;


public class Chofer {

    // aplicar interfaces de State y saca los boolean

    private Auto choferAuto;
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
        setEstado(new Working()); //idea
    }

    public void terminarViaje(){
        setEstado(new Online());
        setCoordenadas(viaje.getDestino());
    }



    public String getId() {
        return id;
    }

    public Auto getChoferAuto(){
        return choferAuto;
    }

    public boolean evaluateOferta(Viaje viaje){
        /**AGREGAAR LOS DATOS DEL VIAJE PARA CONSOLA
         *  EL METEDO EVALUAROFERTA2 SOLUCIONA ESTO
         *  */

        System.out.println("Chofer:"+getId()+"¿Que desea aceptar el viaje?"+"\n"+"1)Aceptar"+" \n"+"2)Rechazar");

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
