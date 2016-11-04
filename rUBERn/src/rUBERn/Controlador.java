package rUBERn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Cliente.*;
import Chofer.*;


public class Controlador {
    private HashMap<String,Cliente> clientes= new HashMap<>();
    private HashMap<String, Chofer> choferes;
    private Buscador buscador;
    private BuscadorDeRegistros buscadorDeRegistros;


    public Controlador(HashMap<String,Chofer> choferes){
        this.choferes = choferes;
        ArrayList<Chofer> choferesList = new ArrayList<Chofer>(choferes.values());
        this.buscador = new Buscador(choferesList);
        buscadorDeRegistros = new BuscadorDeRegistros(new ArrayList<Registro>());
    }

    public void nuevoCliente(Cliente clienteAAgregar) {
        if (!clientes.containsKey(clienteAAgregar.getId())) {
            clientes.put(clienteAAgregar.getId(), clienteAAgregar);
        }
    }

    public void agregarChofer(Chofer choferAAgregar){
        if(!choferes.containsValue(choferAAgregar)) {
            choferes.put(choferAAgregar.getId(), choferAAgregar);
            buscador.addChofer(choferAAgregar);
        }else System.out.println("El chofer ya existe en el sistema.");
    }
    public void addRegistro(Registro registroAAgregar){
        buscadorDeRegistros.addRegistro(registroAAgregar);
    }

    public void removerChofer(String insertDNI) {
        if (choferes.containsKey(insertDNI)) {
            buscador.removeChofer(choferes.get(insertDNI));
            choferes.remove(insertDNI);
        }else{
            System.out.println("No se encontro el chofer a remover");
        }
    }

    public Buscador getBuscador() {
        return buscador;
    }

    public Cliente getCliente(String dni){
        if( clientes.containsKey(dni)){
        return clientes.get(dni);
        }
        throw new NoSeEncontroElClienteException("No se pudo hallar el cliente buscado.");
    }

    public Chofer getChofer(String dni){
        if( choferes.containsKey(dni)){
            return choferes.get(dni);
        }
        throw new NoSeEncontroElChoferException("No se pudo hallar el chofer buscado.");
    }

    public void darViajeAChofer(Viaje viajeADar){
        buscador.darViajeAChofer(viajeADar);
    }

    public Cliente getClienteByViaje(Viaje viaje){
        ArrayList<Cliente> clientes1 = new ArrayList<Cliente>(clientes.values());
        for (Cliente clienteATestear : clientes1){
            if (clienteATestear.getViaje().equals(viaje)){
                return clienteATestear;
            }
        }
        throw new NoSeEncontroElClienteException("No se pudo hallar el cliente buscado.");
    }

    public void buscarRegistrosByCliente(Cliente clienteBuscado) {
        ArrayList<Registro> registrosByCliente = buscadorDeRegistros.buscarRegistrosByCliente(clienteBuscado);
        System.out.println("Los viajes de este cliente son:");
        for (Registro registroAImprimir : registrosByCliente){
            int i = 1;
            System.out.println("Viaje " + i + ":");
            System.out.println("Id del chofer: " + registroAImprimir.getChofer().getId());
            System.out.println("Distancia del viaje: " + registroAImprimir.getViaje().getDistance());
            System.out.println("Cantidad de pasajeros: " + registroAImprimir.getViaje().getNumberOfPassenger());
            System.out.println("Precio: " + registroAImprimir.getViaje().getPrecio());
            System.out.println("Dinero para el chofer: " + registroAImprimir.getDineroParaChofer());
            System.out.println("Dinero para rUBERn: " + registroAImprimir.getDineroParaRUBERn());
            i++;
        }
    }

    public void buscarRegistrosByChofer(Chofer choferBuscado){
        ArrayList<Registro> registrosByChofer = buscadorDeRegistros.buscarRegistrosByChofer(choferBuscado);
        System.out.println("Los viajes de este chofer son:");
        for (Registro registroAImprimir : registrosByChofer){
            int i = 1;
            System.out.println("Viaje " + i + ":");
            System.out.println("Id del cliente: " + registroAImprimir.getCliente().getId());
            System.out.println("Distancia del viaje: " + registroAImprimir.getViaje().getDistance());
            System.out.println("Cantidad de pasajeros: " + registroAImprimir.getViaje().getNumberOfPassenger());
            System.out.println("Precio: " + registroAImprimir.getViaje().getPrecio());
            System.out.println("Dinero para el chofer: " + registroAImprimir.getDineroParaChofer());
            System.out.println("Dinero para rUBERn: " + registroAImprimir.getDineroParaRUBERn());
            i++;
        }
    }

    public HashMap<String, Chofer> getChoferes() {
        return choferes;
    }

    public void imprmirGrillaChoferes(){
        ArrayList<Chofer> choferesList = new ArrayList<Chofer>(choferes.values());
        System.out.println("---------------------------------"+"\n"+
                "Sus choferes");
        for(Chofer imprimirChofer: choferesList){
            System.out.println("Chofer "+imprimirChofer.getId()+" : "+"\t"+
                    imprimirChofer.getUnEstado().toString()+"\t"+
                    "Posicion: ("+imprimirChofer.getChoferCoordenas().getX()+","
                    +imprimirChofer.getChoferCoordenas().getY()+")"+"\t"+
                    "Auto: ("+imprimirChofer.getChoferAuto().getMarca()+", "+
                    imprimirChofer.getChoferAuto().getModelo()+", "+
                    imprimirChofer.getChoferAuto().getCapacidad()+ " max. capacidad)");
        }
        System.out.println("---------------------------------");
    }

    public void imprmirGrillaCliente(){
        ArrayList<Cliente> clienteList = new ArrayList<Cliente>(clientes.values());
        System.out.println("---------------------------------"+"\n"+
                "Sus clientes");
        if(clienteList.isEmpty())
            System.out.println("No se almacenaron clientes.");
        for(Cliente imprmirCliente : clienteList){
            if(imprmirCliente.isTravelling()) {
                System.out.println("Cliente "+imprmirCliente.getId()+" "+"está viajando en este momento.");
            }else{
                System.out.println("Cliente " + imprmirCliente.getId() + "\t" + "Posicion: (" + imprmirCliente.getPosition().getX() + ", "
                        + imprmirCliente.getPosition().getY() + ")");
            }
        }
        System.out.println("---------------------------------");
    }

    public void write(Registro registro) throws IOException {
        String content = registro.toString();
        File file = new File("registro.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }

    public BuscadorDeRegistros getBuscadorDeRegistros() {
        return buscadorDeRegistros;
    }
}
