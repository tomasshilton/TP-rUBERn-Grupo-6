package rUBERn.Formulario;

import java.util.Scanner;

/**
 * Created by Simon1 on 30-Oct-16.
 */
public class FormularioChofer extends Formulario{
    public FormularioChofer(){
        System.out.println("Ingrese ID del chofer");
        Scanner idchofer = new Scanner(System.in);
        choferID = idchofer.next();
    }
}
