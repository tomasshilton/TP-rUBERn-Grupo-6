package Chofer;

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

    public Chofer(Auto choferAuto, double X, double Y){
        this.choferAuto =choferAuto;
        this.choferCoordenas= new Coordenada(X,Y);
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

    public boolean evaluateOferta(Viaje viaje){
        System.out.println("Desea aceptar el viaje? Si o No?");
        /**AGREGAAR LOS DATOS DEL VIAJE PARA CONSOLA*/
        Scanner respuesta = new Scanner(System.in);
        if(respuesta.hasNext("Si")){
            setViaje(viaje);
            return true;
        }
        return false;

    }

}
