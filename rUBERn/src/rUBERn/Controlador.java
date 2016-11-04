package rUBERn;

import java.util.ArrayList;
import java.util.HashMap;

import Cliente.*;
import Chofer.*;


public class Controlador {
    private HashMap<String,Cliente> clientes= new HashMap<>();
    private HashMap<String, Chofer> choferes;
    private Buscador buscador;
    private BuscadorDeRegistros buscadorDeRegistros;
    private Categoria[] categorias = new Categoria[] {new Categoria("Categoria 1",15), new Categoria("Categoria 2", 10), new Categoria("Categoria 3", 7), new Categoria("Categoria 4", 5), new Categoria("Categoria 5", 1)};


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
        choferes.put(choferAAgregar.getId(),choferAAgregar);

        ArrayList<Chofer> choferesList = new ArrayList<Chofer>(choferes.values());
        this.buscador = new Buscador(choferesList);
    }
    public void addRegistro(Registro registroAAgregar){
        buscadorDeRegistros.addRegistro(registroAAgregar);
    }

    public void removerChofer(String insertDNI) {
        if (choferes.containsKey(insertDNI)) {
            choferes.remove(insertDNI);
        }else throw new NoSeEncontroElChoferException("No se encontro el chofer a remover");
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
            System.out.println("Id del chofer: " + registroAImprimir.getChofer().getId());
            System.out.println("Distancia del viaje: " + registroAImprimir.getViaje().getDistance());
            System.out.println("Cantidad de pasajeros: " + registroAImprimir.getViaje().getNumberOfPassenger());
            System.out.println("Precio: " + registroAImprimir.getViaje().getPrecio());
            System.out.println("Dinero para el chofer: " + registroAImprimir.getDineroParaChofer());
            System.out.println("Dinero para rUBERn: " + registroAImprimir.getDineroParaRUBERn());
        }
    }

    public void buscarRegistrosByChofer(Chofer choferBuscado){
        ArrayList<Registro> registrosByChofer = buscadorDeRegistros.buscarRegistrosByChofer(choferBuscado);
        System.out.println("Los viajes de este chofer son:");
        for (Registro registroAImprimir : registrosByChofer){
            System.out.println("Id del cliente: " + registroAImprimir.getCliente().getId());
            System.out.println("Distancia del viaje: " + registroAImprimir.getViaje().getDistance());
            System.out.println("Cantidad de pasajeros: " + registroAImprimir.getViaje().getNumberOfPassenger());
            System.out.println("Precio: " + registroAImprimir.getViaje().getPrecio());
            System.out.println("Dinero para el chofer: " + registroAImprimir.getDineroParaChofer());
            System.out.println("Dinero para rUBERn: " + registroAImprimir.getDineroParaRUBERn());
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
            if(imprmirCliente.getViaje().equals(null)) {
                System.out.println("Cliente " + imprmirCliente.getId() + "\t" + "Posicion: (" + imprmirCliente.getPosition().getX() + ", "
                        + imprmirCliente.getPosition().getY() + ")");
            }else
            System.out.println("Cliente "+imprmirCliente.getId()+" "+"está viajando en este momento.");
        }
        System.out.println("---------------------------------");
    }

    public Categoria getCategoria(int index){
        return categorias[index - 1];
    }
}
