package rUBERn;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.print("Cliente:\n    1. Pedir viaje\n \nChofer:\n    1. Aceptar viaje\n    2. Rechazar viaje\n    3. Completar viaje\n \nrUBERn:\n    1. Nuevo cliente ");
        System.out.println(" \nIngrese un comando");
        Scanner comando = new Scanner(System.in);
        if (comando.hasNext("1"))
            System.out.println("Viaje");
    }
}
