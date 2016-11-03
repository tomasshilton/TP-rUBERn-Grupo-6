package rUBERn;
import Chofer.Estados.*;
import Cliente.Cliente;
import Chofer.*;
import rUBERn.Formulario.FormularioAgregarChofer;
import rUBERn.Formulario.FormularioChofer;
import rUBERn.Formulario.FormularioCliente;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        boolean running = true;
        Chofer chofer1=new Chofer(new Auto("marca1","modelo1",2,new Categoria("categoria1",1)),0,0);
        Chofer chofer2=new Chofer(new Auto("marca2","modelo2",3,new Categoria("categoria2",2)),0,0);
        Chofer chofer3=new Chofer(new Auto("marca3","modelo3",1,new Categoria("categoria3",3)),0,0);
        HashMap<String,Chofer> choferes = new HashMap<>();
        choferes.put("1",chofer1);
        choferes.put("2",chofer2);
        choferes.put("3",chofer3);

        Controlador controlador = new Controlador(choferes);

        while (running) {

            System.out.println("Cliente:"+"\n"+"\t"+
                    "1. Pedir viaje" );
            System.out.println("Chofer:"+"\n"+"\t"+
                    "2.Completar viaje"+"\n"+"\t"+
                    "3.Finalizar Jornada"+"\n"+"\t"+
                    "4.Iniciar Jornada");
            System.out.println("rUBERn: "+"\n"+"\t"+
                    "5.Agregar Chofer"+"\n"+"\t"+
                    "6.Sacar Chofer"+"\n"+"\t"+
                    "0.Salir");
            System.out.println(" \nIngrese un comando");
            Scanner input = new Scanner(System.in);
            int comando = input.nextInt();


            switch (comando){
                case 1:
                    FormularioCliente formularioCliente = new FormularioCliente();
                    controlador.nuevoCliente(formularioCliente.getClienteID(),new Cliente(new Coordenada(formularioCliente.getCoordenadaX(),formularioCliente.getCoordenadaY())));
                    controlador.getCliente(formularioCliente.getClienteID()).askForTrip(new Coordenada(formularioCliente.getDestinoX(),formularioCliente.getDestinoY()),formularioCliente.getCantidad());
                    controlador.darViajeAChofer(controlador.getCliente(formularioCliente.getClienteID()).getViaje());
                    break;
                case 2:
                    FormularioChofer formularioTerminarViaje=new FormularioChofer();
                    Viaje viajeATerminar = controlador.getChofer(formularioTerminarViaje.getChoferID()).getViaje();
                    Registro nuevoRegistro = new Registro(viajeATerminar, controlador.getClienteByViaje(viajeATerminar), controlador.getChofer(formularioTerminarViaje.getChoferID()));
                    controlador.addRegistro(nuevoRegistro);
                    controlador.getClienteByViaje(viajeATerminar).terminarViaje();
                    controlador.getChofer(formularioTerminarViaje.getChoferID()).terminarViaje();
                    break;
                case 3:
                    FormularioChofer formularioFinalizarJornada=new FormularioChofer();
                    controlador.getChofer(formularioFinalizarJornada.getChoferID()).goOffline();
                    break;
                case 4:
                    FormularioChofer formularioIniciarJornada=new FormularioChofer();
                    controlador.getChofer(formularioIniciarJornada.getChoferID()).goOnline();
                    break;
                case 5:
                    FormularioAgregarChofer formularioAgregarChofer = new FormularioAgregarChofer();
                    controlador.agregarChofer(formularioAgregarChofer.getChoferID(),new Chofer(new Auto(formularioAgregarChofer.getMarca(),formularioAgregarChofer.getModelo(),formularioAgregarChofer.getCapacidad(),new Categoria(formularioAgregarChofer.getCategoria(),formularioAgregarChofer.getCostoAdicional())),0,0));
                    break;
                case 6:
                    FormularioChofer formularioRemoverChofer = new FormularioChofer();
                    controlador.removerChofer(formularioRemoverChofer.getChoferID());
                case 0:
                    System.out.println("Saliendo");
                    running=false;
                    break;
                default:
                    System.out.println("Por favor ingrese un comando correcto dentro del menú.");
            }
        }
    }
}