package rUBERn;
import Cliente.Cliente;
import Chofer.*;
import rUBERn.Formulario.FormularioAgregarChofer;
import rUBERn.Formulario.FormularioDNI;
import rUBERn.Formulario.FormularioCliente;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws IOException {
        boolean running = true;
        Chofer chofer1=new Chofer("1",new Auto("marca1","modelo1",2,new Categoria("Categoria 1",15)),0,0);
        Chofer chofer2=new Chofer("2",new Auto("marca2","modelo2",3,new Categoria("Categoria 2",10)),0,0);
        Chofer chofer3=new Chofer("3",new Auto("marca3","modelo3",1,new Categoria("Categoria 3",7)),0,0);
        HashMap<String,Chofer> choferes = new HashMap<>();
        choferes.put(chofer1.getId(),chofer1);
        choferes.put(chofer2.getId(),chofer2);
        choferes.put(chofer3.getId(),chofer3);

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
                    "7.Mostrar Choferes"+"\n"+"\t"+
                    "8.Mostrar Clientes"+"\n"+"\t"+
                    "9.Mostrar registros de chofer"+"\n"+"\t"+
                    "10.Mostrar registros de cliente"+"\n"+"\t"+
                    "11.Mostrar comisiones de rUBERn"+"\n"+"\t"+
                    "0.Salir");
            System.out.println("Por favor ingrese los valores de a uno a la vez.");
            System.out.println(" \nIngrese un comando:");
            Scanner input = new Scanner(System.in);
            int comando = input.nextInt();


            switch (comando){
                case 1:
                    FormularioCliente formularioCliente = new FormularioCliente();
                    controlador.nuevoCliente(new Cliente(new Coordenada(formularioCliente.getCoordenadaX(),formularioCliente.getCoordenadaY()),formularioCliente.getID()));
                    controlador.getCliente(formularioCliente.getID()).askForTrip(new Coordenada(formularioCliente.getDestinoX(),formularioCliente.getDestinoY()),formularioCliente.getCantidad());
                    if(controlador.darViajeAChofer(controlador.getCliente(formularioCliente.getID()).getViaje()) ){
                        controlador.getCliente(formularioCliente.getID()).travelling();
                    }
                    break;
                case 2:
                    FormularioDNI formularioTerminarViaje=new FormularioDNI();
                    if(controlador.getChofer(formularioTerminarViaje.getID()).getViaje() != null) {
                        Viaje viajeATerminar = controlador.getChofer(formularioTerminarViaje.getID()).getViaje();
                        Registro nuevoRegistro = new Registro(viajeATerminar, controlador.getClienteByViaje(viajeATerminar), controlador.getChofer(formularioTerminarViaje.getID()));
                        controlador.addRegistro(nuevoRegistro);
                        controlador.write();
                        controlador.getClienteByViaje(viajeATerminar).terminarViaje();
                        controlador.getChofer(formularioTerminarViaje.getID()).terminarViaje();
                    } else {
                        System.out.println("El chofer seleccionado no esta realizando ningun viaje");
                    }
                    break;
                case 3:
                    FormularioDNI formularioFinalizarJornada=new FormularioDNI();
                    controlador.getChofer(formularioFinalizarJornada.getID()).goOffline();
                    break;
                case 4:
                    FormularioDNI formularioIniciarJornada=new FormularioDNI();
                    controlador.getChofer(formularioIniciarJornada.getID()).goOnline();
                    break;
                case 5:
                    FormularioAgregarChofer formularioAgregarChofer = new FormularioAgregarChofer();
                    controlador.agregarChofer(new Chofer(formularioAgregarChofer.getID(),new Auto(formularioAgregarChofer.getMarca(),formularioAgregarChofer.getModelo(),formularioAgregarChofer.getCapacidad(),formularioAgregarChofer.addCategoria()),0,0));
                    break;
                case 6:
                    FormularioDNI formularioRemoverChofer = new FormularioDNI();
                    controlador.removerChofer(formularioRemoverChofer.getID());
                    break;
                case 7:
                    controlador.imprmirGrillaChoferes();
                    break;
                case 8:
                    controlador.imprmirGrillaCliente();
                    break;
                case 9:
                    FormularioDNI formularioBuscarChofer = new FormularioDNI();
                    controlador.buscarRegistrosByChofer(controlador.getChofer(formularioBuscarChofer.getID()));
                    break;
                case 10:
                    FormularioDNI formularioBuscarCliente = new FormularioDNI();
                    controlador.buscarRegistrosByCliente(controlador.getCliente(formularioBuscarCliente.getID()));
                    break;
                case 11:
                    controlador.mostrarComisiones();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    running=false;
                    break;
                default:
                    System.out.println("Por favor ingrese un comando correcto dentro del menú.");
                    break;
            }
        }
    }
}