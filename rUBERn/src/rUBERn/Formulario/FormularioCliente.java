package rUBERn.Formulario;

import java.util.Scanner;

/**
 * Created by Simon1 on 28-Oct-16.
 */
public class FormularioCliente extends Formulario{

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
        System.out.println("¿Cuantos pasajeros son?");
        Scanner cantidad=new Scanner(System.in);
        this.cantidad = cantidad.nextInt();
    }
}
