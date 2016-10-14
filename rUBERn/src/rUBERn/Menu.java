package rUBERn;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
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
                System.out.println("viaje3");
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
            case 8:
                System.out.println("viaje8");
                break;

        }

    }
}
