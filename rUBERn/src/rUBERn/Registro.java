package rUBERn;

//FALTA TERMINAR

import Chofer.Chofer;
import Cliente.Cliente;

public class Registro {

    private Viaje viaje;
    private Cliente cliente;
    private Chofer chofer;
    private double dineroParaChofer;
    private double dineroParaRUBERn;

    public Registro(Viaje viaje, Cliente cliente, Chofer chofer){
        this.viaje = viaje;
        this.cliente = cliente;
        this.chofer = chofer;
        dineroParaChofer = (viaje.getPrecio())*0.90;
        dineroParaRUBERn = (viaje.getPrecio())*0.10;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public double getDineroParaChofer() {
        return dineroParaChofer;
    }

    public double getDineroParaRUBERn() {
        return dineroParaRUBERn;
    }
}
