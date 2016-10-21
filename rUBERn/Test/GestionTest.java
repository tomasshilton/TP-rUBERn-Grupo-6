import java.util.ArrayList;
import Chofer.Chofer;
import Chofer.Auto;
import Chofer.Categoria;
import org.junit.Test;
import rUBERn.Coordenada;
import rUBERn.Gestion;
import rUBERn.Viaje;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lucas on 20/10/2016.
 */
public class GestionTest {
    /**HACER PUBLICO LOS METODOS AUXILIARES */
    Categoria cat1 = new Categoria("cat1", 250);
    Auto car1 = new Auto("abs", "abs ", 2, cat1);
    Chofer chofer1 = new Chofer(car1, 0, 0);

    Categoria cat2 = new Categoria("cat2", 50);
    Auto car2 = new Auto("abs", "abs ", 4, cat2);
    Chofer chofer2 = new Chofer(car2, 0, 0);

    Categoria cat3 = new Categoria("cat3", 150);
    Auto car3 = new Auto("abs", "abs ", 6, cat3);
    Chofer chofer3 = new Chofer(car3, 0, 0);


    Coordenada coord1 = new Coordenada(0,0);
    Coordenada coord2 = new Coordenada(2,2);
    Viaje viaje = new Viaje(coord1,coord2,4);

    @Test
    public void FilterOnlineTest(){
        ArrayList<Chofer> choferes = new ArrayList<>();
        choferes.add(chofer1);
        choferes.add(chofer2);
        choferes.add(chofer3);

        Gestion gestion = new Gestion(choferes);

        choferes.get(1).ocupar(); // me aseguro descartar un elemento en el array auxiliar

        ArrayList<Chofer> choferesTester = gestion.filterOnline(choferes);
        assertTrue (choferesTester.contains(chofer1));

        choferes.get(0).ocupar(); // como ejecuta el metodo seguro es Chofer1
        choferesTester=gestion.filterOnline(choferes);

        assertFalse(choferesTester.contains(chofer1));
    }

    @Test
    public void FilterCapacityTester(){
        ArrayList<Chofer> choferes = new ArrayList<>();
        choferes.add(chofer1);
        choferes.add(chofer2);
        choferes.add(chofer3);

        Gestion gestion = new Gestion(choferes);

        ArrayList<Chofer> choferesTester = gestion.filterCapacity(viaje,choferes);

        assertTrue(choferesTester.contains(chofer2));

    }

    @Test
    public void sortByCostoDeImagenTest(){
        ArrayList<Chofer> choferes = new ArrayList<>();
        choferes.add(chofer1);
        choferes.add(chofer2);
        choferes.add(chofer3);

        Gestion gestion = new Gestion(choferes);

        ArrayList<Chofer> choferesTester = gestion.sortByCostoDeImagen(choferes,viaje);

        assertTrue(chofer1.equals(choferesTester.get(2)));


    }
}
