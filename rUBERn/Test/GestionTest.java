import java.util.ArrayList;
import Chofer.Chofer;
import Chofer.Auto;
import Chofer.Categoria;
import org.junit.Test;
import rUBERn.Gestion;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lucas on 20/10/2016.
 */
public class GestionTest {
    Categoria cat1 = new Categoria("cat1", 50);
    Auto car1 = new Auto("abs", "abs ", 2, cat1);
    Chofer chofer1 = new Chofer(car1, 0, 0);

    Categoria cat2 = new Categoria("cat2", 150);
    Auto car2 = new Auto("abs", "abs ", 4, cat2);
    Chofer chofer2 = new Chofer(car2, 0, 0);

    Categoria cat3 = new Categoria("cat3", 250);
    Auto car3 = new Auto("abs", "abs ", 6, cat3);
    Chofer chofer3 = new Chofer(car3, 0, 0);

    @Test
    public void GestionFilterOnlineTest(){
        ArrayList<Chofer> choferes = new ArrayList<>();
        choferes.add(chofer1);
        choferes.add(chofer2);
        choferes.add(chofer3);

        Gestion gestion = new Gestion(choferes);

        choferes.get(2).ocupar(); // me aseguro descartar un elemento en el array auxiliar

        ArrayList<Chofer> choferesCompareTo = new ArrayList<>(); // esto esta de mas si hacemos lo de abajo

        gestion.filterOnline();/** SI HACEMOS VOID EL MENSAJES, HABRIA QUE HACER UN GETTER PARA OBTENER ESE ARRAY AUXILIAR MODIFICADO  */
        assertTrue (chofer1.equals(choferesCompareTo.get(0)));

        choferes.get(0).ocupar();

    }
}
