package rUBERn;

import Cliente.Cliente;
import Chofer.Chofer;
import java.util.ArrayList;

public class BuscadorDeRegistros {

    private ArrayList<Registro> registros;

    public BuscadorDeRegistros(ArrayList<Registro> registros){
        this.registros = registros;
    }

    public void addRegistro(Registro registroAAgregar){
        registros.add(registroAAgregar);
    }

    public ArrayList<Registro> buscarRegistrosByCliente(Cliente clienteBuscado){
        ArrayList<Registro> registrosARetornar = new ArrayList<Registro>();
        for(Registro registroATestear : registros){
            if (registroATestear.getCliente().equals(clienteBuscado)){
                registrosARetornar.add(registroATestear);
            }
        }
        return registrosARetornar;
    }

    public ArrayList<Registro> buscarRegistrosByChofer(Chofer choferBuscado){
        ArrayList<Registro> registrosARetornar = new ArrayList<Registro>();
        for(Registro registroATestear : registros){
            if (registroATestear.getChofer().equals(choferBuscado)){
                registrosARetornar.add(registroATestear);
            }
        }
        return registrosARetornar;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }
}
