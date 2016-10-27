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

    public Cliente getCliente(String id){
        for(Cliente cliente : clientes){
            if(cliente.getId().equals(id)){
                return cliente;
            }
            if((clientes.indexOf(cliente)==clientes.size()-1)&&(cliente.getId().equals(id))){
                throw new NoSeEncontroElClienteException("no se pudo hayar el cliente buscado");
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
