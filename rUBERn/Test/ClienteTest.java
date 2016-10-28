import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Cliente.Cliente;
import rUBERn.Coordenada;
import rUBERn.Viaje;

/**
 * Created by Lucas on 13/10/2016.
 */
public class ClienteTest {
    Coordenada desde = new Coordenada(0,0);
    Coordenada hasta = new Coordenada(5,5);

    @Test
    public void clienteTesterSinViaje(){
        Cliente firstClient = new Cliente("asd",desde);
        assertTrue(firstClient.getViaje()==(null));

    }
    @Test
    public void clienteTesterConViaje(){
        Cliente firstClient = new Cliente("asd",desde);
        firstClient.askForTrip(hasta,1);
        Viaje firstTrip = firstClient.getViaje();

        assertFalse(firstClient.getViaje().equals(null));
        assertEquals(1,firstTrip.getNumberOfPassenger());

        assertFalse(firstClient.getPosition()==hasta);
    }

}
