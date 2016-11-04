package rUBERn.Formulario;

import Chofer.Categoria;

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
        System.out.println("Ingrese la marca, el modelo, la capacidad y el numero correspondiente a la categoria(1-5) del auto del nuevo chofer");
        Scanner scannerMarca = new Scanner(System.in);
        marca = scannerMarca.next();
        Scanner scannerModelo = new Scanner(System.in);
        modelo = scannerModelo.next();
        Scanner scannerCapacidad = new Scanner(System.in);
        capacidad = scannerCapacidad.nextInt();
        Scanner catScanner = new Scanner(System.in);
        cat=catScanner.nextInt();
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

    public Categoria addCategoria(){
        Categoria ret = null;
        switch (cat){
            case 1:
                ret = new Categoria("Categoria 1", 15);
                break;
            case 2:
                ret = new Categoria("Categoria 2", 10);
                break;
            case 3:
                ret = new Categoria("Categoria 3", 7);
                break;
            case 4:
                ret = new Categoria("Categoria 4", 5);
                break;
            case 5:
                ret = new Categoria("Categoria 5", 1);//
                break;
            default:
                System.out.println("Por favor ingrese un comando correcto.");
                addCategoria();
        }
        return ret;
    }

    public int getCat() {
        return cat;
    }
}
