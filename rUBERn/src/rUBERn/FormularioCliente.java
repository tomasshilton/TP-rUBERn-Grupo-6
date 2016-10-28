package rUBERn;

import java.util.Scanner;

/**
 * Created by Simon1 on 28-Oct-16.
 */
public class FormularioCliente {
    int coordenadaX;
    int coordenadaY;
    String clienteID;
    int destinoX;
    int destinoY;
    int cant;

    public FormularioCliente(){
        System.out.println("Ingrese su ubicacion (X, Y)");
        Scanner cX = new Scanner(System.in);
        coordenadaX = cX.nextInt();
        Scanner cY = new Scanner(System.in);
        coordenadaY = cY.nextInt();
        System.out.println("Ingrese su DNI");
        Scanner id = new Scanner(System.in);
        clienteID = id.next();
        System.out.println("Ingrese su destino (X,Y)");
        Scanner dX = new Scanner(System.in);
        destinoX = dX.nextInt();
        Scanner dY = new Scanner(System.in);
        destinoY = dY.nextInt();
        System.out.println("Cuantos pasajeros son?");
        Scanner cantidad=new Scanner(System.in);
        cant = cantidad.nextInt();
    }

    public int getDestinoX() {
        return destinoX;
    }

    public int getDestinoY() {
        return destinoY;
    }

    public int getCant() {
        return cant;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public String getClienteID() {
        return clienteID;
    }
}
