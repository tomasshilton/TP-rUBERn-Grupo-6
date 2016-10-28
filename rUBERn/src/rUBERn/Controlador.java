package rUBERn;

import java.util.ArrayList;
import java.util.HashMap;

import Cliente.Cliente;
import Chofer.Chofer;

public class Controlador {
    private HashMap<String,Cliente> clientes= new HashMap<>();
    private HashMap<String, Chofer> choferes;
    private Buscador buscador;

    public Controlador(HashMap<String,Chofer> choferes){
        this.choferes = choferes;
        ArrayList<Chofer> choferesList = new ArrayList<Chofer>(choferes.values());
        this.buscador = new Buscador(choferesList);
    }

    public void nuevoCliente(String insertDNI,Cliente clienteAAgregar){
        clientes.put(insertDNI,clienteAAgregar);
    }

    public void agregarChofer(String insertDNI,Chofer choferAAgregar){
        choferes.put(insertDNI,choferAAgregar);

        ArrayList<Chofer> choferesList = new ArrayList<Chofer>(choferes.values());
        this.buscador = new Buscador(choferesList);
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

}
