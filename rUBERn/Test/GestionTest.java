import java.util.ArrayList;
import Chofer.Chofer;
import Chofer.Auto;
import Chofer.Categoria;

/**
 * Created by Lucas on 20/10/2016.
 */
public class GestionTest {

    Categoria cat1 = new Categoria("cat1", 50);
    Auto carOne = new Auto("abs", "abs ", 4, cat1);
    Chofer uno = new Chofer(carOne, 0, 0);

    Categoria cat2 = new Categoria("cat2", 150);
    Auto carTwo = new Auto("abs", "abs ", 2, cat2);
    Chofer dos = new Chofer(carTwo, 0, 0);

    Categoria cat3 = new Categoria("cat3", 250);
    Auto carThree = new Auto("abs", "abs ", 6, cat3);
    Chofer tres = new Chofer(carThree, 0, 0);


    ArrayList<Chofer> choferes = new ArrayList<>();
}
