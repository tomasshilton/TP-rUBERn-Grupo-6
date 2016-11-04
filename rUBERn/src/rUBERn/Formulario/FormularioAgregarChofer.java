package rUBERn.Formulario;

import java.util.Scanner;

/**
 * Created by Simon1 on 30-Oct-16.
 */
public class FormularioAgregarChofer extends FormularioChofer {
    String categoria;
    int capacidad;
    String marca;
    String modelo;
    double costoAdicional;
    int cat;

    public FormularioAgregarChofer(){
        super();
        System.out.println("Ingrese la marca, el modelo, la capacidad y el numero correspondiente a la categoria del auto del nuevo chofer");
        Scanner scannerMarca = new Scanner(System.in);
        marca = scannerMarca.next();
        Scanner scannerModelo = new Scanner(System.in);
        modelo = scannerModelo.next();
        Scanner scannerCapacidad = new Scanner(System.in);
        capacidad = scannerCapacidad.nextInt();
        Scanner catScanner = new Scanner(System.in);
        cat=catScanner.nextInt();
        addCategoria(cat);
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

    public void addCategoria(int cat){
        switch (cat){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

            default:
                System.out.println("Por favor ingrese un comando correcto dentro del menú.");
                break;
        }
    }
}
