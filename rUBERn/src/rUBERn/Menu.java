package rUBERn;
import Chofer.Estados.*;
import Cliente.Cliente;
import Chofer.*;

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
                    FormularioCliente formularioCliente = new FormularioCliente();
                    controlador.nuevoCliente(formularioCliente.getClienteID(),new Cliente(new Coordenada(formularioCliente.getCoordenadaX(),formularioCliente.getCoordenadaY())));
                    controlador.getCliente(formularioCliente.getClienteID()).askForTrip(new Coordenada(formularioCliente.getDestinoX(),formularioCliente.getDestinoY()),formularioCliente.getCant());
                    controlador.darViajeAChofer(controlador.getCliente(formularioCliente.getClienteID()).getViaje());
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
                    System.out.println("Ingrese el ID del chofer a agregar");
                    Scanner choferAAgregar = new Scanner(System.in);
                    String  idChoferAAgregar = choferAAgregar.next();
                    System.out.println("Ingrese la marca, el modelo, la capacidad, el costo adicional, y la categoria del auto del nuevo chofer");
                    Scanner scannerMarca = new Scanner(System.in);
                    String nuevaMarca = scannerMarca.next();
                    Scanner scannerModelo = new Scanner(System.in);
                    String nuevoModelo = scannerModelo.next();
                    Scanner scannerCapacidad = new Scanner(System.in);
                    int nuevaCapacidad = scannerCapacidad.nextInt();
                    Scanner scannerCategoria = new Scanner(System.in);
                    String nuevaCategoria = scannerCategoria.next();
                    Scanner scannerCostoAdicional = new Scanner(System.in);
                    double nuevoCostoAdicional = scannerCostoAdicional.nextDouble();
                    controlador.agregarChofer(idChoferAAgregar,new Chofer(new Auto(nuevaMarca,nuevoModelo,nuevaCapacidad,new Categoria(nuevaCategoria,nuevoCostoAdicional)),0,0));
                    break;
                case 6:
                    System.out.println("Ingrese el ID del chofer a remover");
                    Scanner choferARemover = new Scanner(System.in);
                    String  idChoferARemover = choferARemover.next();
                    controlador.removerChofer(idChoferARemover);
                case 0:
                    System.out.println("Saliendo");
                    running=false;
                default:
                    System.out.println("Por favor ingrese un comando correcto dentro del menú.");
            }
        }
    }
}