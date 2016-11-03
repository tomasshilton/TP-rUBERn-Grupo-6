package Chofer.OfertaDeViaje;
import rUBERn.Viaje;

import java.util.Scanner;

/**
 * Created by Lucas on 24/10/2016.
 */
public abstract class OfertaDeViaje {
    protected Viaje viaje;

    public OfertaDeViaje(Viaje viaje){
        this.viaje=viaje;
    }

    public abstract boolean responderOferta();

    public void pedirInfoDeViaje(){
        System.out.println("------------------"+"\n"
                +"Punto de encuentro: ("+viaje.getDesde().getX()+","+viaje.getDesde().getY()+")" +"\n"
                +"Punto de Destino: ("+viaje.getDestino().getX()+","+viaje.getDestino().getY()+")" +"\n"
                +"Cantidad de personas: "+viaje.getNumberOfPassenger()+"\n"
                +"------------------");
    }

    public int elegirOpcionDeOferta(){
        Scanner input = new Scanner(System.in);
        int comando = input.nextInt();
        if(comando!=1 && comando!=2 && comando!=3){
            System.out.println("Elija una opcion valida. ");
            elegirOpcionDeOferta();
        }
        return comando;
    }

}
