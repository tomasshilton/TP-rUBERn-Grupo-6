import Chofer.Auto;
import Chofer.Categoria;
import Chofer.Chofer;
import org.junit.Test;
import rUBERn.Coordenada;
import rUBERn.Viaje;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lucas on 13/10/2016.
 */
public class ChoferTest {
    Categoria categoria= new Categoria("Mustang", 1);
    Auto auto = new Auto("Ford", "Mustang",4, categoria);
    Coordenada choferCoord = new Coordenada(1,1);
    Coordenada desde = new Coordenada(0,0);
    Coordenada hasta = new Coordenada(1,1);

    Chofer chofer = new Chofer(auto,choferCoord.getX(),choferCoord.getY());

    @Test
    public void choferTestDisponibilidad(){
        assertTrue(chofer.disponibilidad());

        chofer.finalizarJornada();
        assertFalse(chofer.disponibilidad());

        chofer.iniciarJornada();
        chofer.ocupar();

        assertFalse(chofer.disponibilidad());

        chofer.liberar();
        assertTrue(chofer.disponibilidad());
    }

    @Test
    public void setChoferCoordTest(){
        assertTrue(chofer.getChoferCoordenas().equals(choferCoord));
        chofer.setCoordenadas(hasta);
        assertFalse(chofer.getChoferCoordenas().equals(choferCoord));
    }

    @Test
    public void setChoferViajeTest(){
        Viaje trip = new Viaje(desde,hasta,1);
        chofer.setViaje(trip);
        assertFalse(chofer.disponibilidad());

        chofer.liberar();

        assertTrue(chofer.disponibilidad());
    }
}
