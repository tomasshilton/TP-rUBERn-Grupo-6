package rUBERn;
import Cliente.Cliente;
import Chofer.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        boolean running = true;
        Chofer chofer1=new Chofer(new Auto("marca1","modelo1",2,new Categoria("categoria1",1)),0,0,"id");
        Chofer chofer2=new Chofer(new Auto("marca2","modelo2",3,new Categoria("categoria2",2)),0,0,"id");
        Chofer chofer3=new Chofer(new Auto("marca3","modelo3",1,new Categoria("categoria3",3)),0,0,"id");
        ArrayList<Chofer> choferes = new ArrayList<>();
        choferes.add(chofer1);
        choferes.add(chofer2);
        choferes.add(chofer3);

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
                    break;
                case 2:
                    System.out.println("ingrese ID del chofer");
                    Scanner idchofer = new Scanner(System.in);
                    String choferID = idchofer.next();
                    controlador.getChofer(choferID).terminarViaje();
                    break;
                case 3:
                    System.out.println("ingrese ID del chofer");
                    Scanner idChofer = new Scanner(System.in);
                    String choferId = idChofer.next();
                    controlador.getChofer(choferId).finalizarJornada();
                    break;
                case 4:
                    System.out.println("ingrese ID del chofer");
                    Scanner otroIdChofer = new Scanner(System.in);
                    String otroChoferId = otroIdChofer.next();
                    controlador.getChofer(otroChoferId).iniciarJornada();
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