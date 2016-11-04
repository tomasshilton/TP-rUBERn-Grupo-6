package rUBERn.Formulario;

import java.util.Scanner;

/**
 * Created by Simon1 on 30-Oct-16.
 */
public class FormularioDNI extends Formulario{
    public FormularioDNI(){
        System.out.println("Ingrese DNI:");
        Scanner id = new Scanner(System.in);
        ID = id.next();
    }
}
