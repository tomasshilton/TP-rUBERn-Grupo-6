package rUBERn.Formulario;


import java.util.Scanner;

/**
 * Created by Simon1 on 30-Oct-16.
 */
public class FormularioAgregarChofer extends Formulario {
    String categoria;
    int capacidad;
    String marca;
    String modelo;
    double costoAdicional;

    public FormularioAgregarChofer(){
        System.out.println("Ingrese el ID del chofer a agregar");
        Scanner choferAAgregar = new Scanner(System.in);
        choferID = choferAAgregar.next();
        System.out.println("Ingrese la marca, el modelo, la capacidad, el costo adicional, y la categoria del auto del nuevo chofer");
        Scanner scannerMarca = new Scanner(System.in);
        marca = scannerMarca.next();
        Scanner scannerModelo = new Scanner(System.in);
        modelo = scannerModelo.next();
        Scanner scannerCapacidad = new Scanner(System.in);
        capacidad = scannerCapacidad.nextInt();
        Scanner scannerCategoria = new Scanner(System.in);
        categoria = scannerCategoria.next();
        Scanner scannerCostoAdicional = new Scanner(System.in);
        costoAdicional = scannerCostoAdicional.nextDouble();
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }
}
