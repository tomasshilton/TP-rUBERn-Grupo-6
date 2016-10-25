package rUBERn;

import java.util.ArrayList;
import Cliente.Cliente;
import Chofer.Chofer;

public class Controlador {

    private ArrayList<Cliente> clientes;
    private ArrayList<Chofer> choferes;
    private Buscador buscador;

    public Controlador(ArrayList<Chofer> choferes){
        this.choferes = choferes;
        buscador = new Buscador(choferes);
    }

    public void nuevoCliente(Cliente clienteAAgregar){
        clientes.add(clienteAAgregar);
    }

    public void agregarChofer(Chofer choferAAgregar){
        choferes.add(choferAAgregar);
        buscador.addChofer(choferAAgregar);
    }

    public Buscador getBuscador() {
        return buscador;
    }

    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getCliente(Cliente clienteBuscado){
        for(Cliente clienteATestear : clientes){
            if (clienteBuscado.equals(clienteATestear)){
                return clienteATestear;
            } else {
                throw new NoSeEncontroElClienteException("El cliente buscado no se encontro");
            }
        }
    }

    public Chofer getChofer(Chofer choferBuscado){
        for(Chofer choferATestear : choferes){
            if (choferBuscado.equals(choferATestear)){
                return choferATestear;
            } else {
                throw new NoSeEncontroElChoferException("El chofer buscado no se encontro");
            }
        }
    }

    public void darViajeAChofer(Viaje viajeADar){
        buscador.darViajeAChofer(viajeADar);
    }



















}
