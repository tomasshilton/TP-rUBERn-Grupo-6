package rUBERn;
import Chofer.Estados.*;
import Cliente.Cliente;
import Chofer.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        boolean running = true;
        Chofer chofer1=new Chofer(new Auto("marca1","modelo1",2,new Categoria("categoria1",1)),0,0);
        Chofer chofer2=new Chofer(new Auto("marca2","modelo2",3,new Categoria("categoria2",2)),0,0);
        Chofer chofer3=new Chofer(new Auto("marca3","modelo3",1,new Categoria("categoria3",3)),0,0);
        HashMap<String,Chofer> choferes = new HashMap<>();
        choferes.put("1",chofer1);
        choferes.put("2",chofer2);
        choferes.put("3",chofer3);

        Controlador controlador = new Controlador(choferes);

        while (running) {

            System.out.println("Cliente:"+"\n"+"\t"+
                    "1. Pedir viaje" );
            System.out.println("Chofer:"+"\n"+"\t"+
                    "2.Completar viaje"+"\n"+"\t"+
                    "3.Finalizar Jornada"+"\n"+"\t"+
                    "4.Iniciar Jornada");
            System.out.println("rUBERn: "+"\n"+"\t"+
                    "5.Agregar Chofer"+"\n"+"\t"+
                    "6.Sacar Chofer"+"\n"+"\t"+
                    "0.Salir");
            System.out.println(" \nIngrese un comando");
            Scanner input = new Scanner(System.in);
            int comando = input.nextInt();


            switch (comando){
                case 1:
                    System.out.println("Ingrese su ubicacion (X, Y)");
                    Scanner cX = new Scanner(System.in);
                    int coordenadaX = cX.nextInt();
                    Scanner cY = new Scanner(System.in);
                    int coordenadaY = cY.nextInt();
                    System.out.println("Ingrese su DNI");
                    Scanner id = new Scanner(System.in);
                    String clienteID = id.next();
                    /**Si usamos hashmaps, el contains verifique si el cliente esta todavia. Si esta, sigue viajando exception, y sino que lo agregue*/
                    Cliente cliente = new Cliente(clienteID,new Coordenada(coordenadaX,coordenadaY));
                    controlador.nuevoCliente(cliente);
                    System.out.println("Ingrese su destino (X,Y)");
                    Scanner dX = new Scanner(System.in);
                    int destinoX = dX.nextInt();
                    Scanner dY = new Scanner(System.in);
                    int destinoY = dY.nextInt();
                    System.out.println("Cuantos pasajeros son?");
                    Scanner cantidad=new Scanner(System.in);
                    int cant = cantidad.nextInt();
                    controlador.getCliente(clienteID).askForTrip(new Coordenada(destinoX,destinoY),cant);
                    controlador.darViajeAChofer(controlador.getCliente(clienteID).getViaje());
                    break;
                case 2:
                    System.out.println("Ingrese ID del chofer");
                    Scanner idchofer = new Scanner(System.in);
                    String choferID = idchofer.next();
                    controlador.getChofer(choferID).terminarViaje();
                    /**remover al cliente de la lista de clientes al finalizar el viaje. si usamos hashmap para viajes le pasamos un key al viaje para identificar cliente*/
                    break;
                case 3:
                    System.out.println("Ingrese ID del chofer");
                    Scanner idChofer = new Scanner(System.in);
                    String choferId = idChofer.next();
                    controlador.getChofer(choferId).setEstado(new Offline());
                    break;
                case 4:
                    System.out.println("Ingrese ID del chofer");
                    Scanner otroIdChofer = new Scanner(System.in);
                    String otroChoferId = otroIdChofer.next();
                    controlador.getChofer(otroChoferId).setEstado(new Online());
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Saliendo");
                    running=false;
                default:
                    System.out.println("Por favor ingrese un comando correcto dentro del menú.");
            }
        }
    }
}