import org.junit.Test;
import static org.junit.Assert.assertEquals;
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
        Coordenada desde = new Coordenada(0,0);
        Coordenada hasta = new Coordenada(5,5);

        Cliente firstClient = new Cliente(desde);
        assertTrue(firstClient.getViaje().equals(null));

    }
    @Test
    public
}
