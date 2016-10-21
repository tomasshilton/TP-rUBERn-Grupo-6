package rUBERn;

import java.util.ArrayList;
import java.util.Scanner;
import Chofer.*;
import Cliente.Cliente;

public class Menu {
    public static void main(String[] args) {
        Chofer chofer1=new Chofer(new Auto("marca1","modelo1",2,new Categoria("categoria1",1)),0,0);
        Chofer chofer2=new Chofer(new Auto("marca2","modelo2",3,new Categoria("categoria2",2)),0,0);
        Chofer chofer3=new Chofer(new Auto("marca3","modelo3",1,new Categoria("categoria3",3)),0,0);
        ArrayList<Chofer> choferes = new ArrayList<>();
        choferes.add(chofer1);
        choferes.add(chofer2);
        choferes.add(chofer3);

        Gestion gestion = new Gestion(choferes);
        ArrayList<Cliente> clientes = new ArrayList<>();


        System.out.print("Cliente:\n    1. Pedir viaje\n \nChofer:\n    2. Completar viaje\n \nrUBERn:\n    3. Nuevo cliente ");
        System.out.println(" \nIngrese un comando");
        Scanner input = new Scanner(System.in);
        int comando = input.nextInt();



        switch (comando){
            case 1:
                System.out.println("viaje1");
                break;
            case 2:
                System.out.println("viaje2");
                break;
            case 3:
                System.out.println("Ingrese su ubicacion (X, Y)");
                Scanner input1 = new Scanner(System.in);
                int coordenadaX = input1.nextInt();
                Scanner input2 = new Scanner(System.in);
                int coordenadaY = input2.nextInt();
                clientes.add(new Cliente(new Coordenada(coordenadaX,coordenadaY))); //el cliente no tiene nombre, hay que ver como hacer que cada nuevo cliente se guarde bajo un nombre distinto
                break;
            case 4:
                System.out.println("viaje4");
                break;
            case 5:
                System.out.println("viaje5");
                break;
            case 6:
                System.out.println("viaje6");
                break;
            case 7:
                System.out.println("viaje7");
                break;

        }
    }
}