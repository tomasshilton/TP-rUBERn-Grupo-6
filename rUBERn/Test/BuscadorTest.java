//import java.util.ArrayList;
//import Chofer.Chofer;
//import Chofer.Auto;
//import Chofer.Categoria;
//import Chofer.Estados.Working;
//import org.junit.Test;
//import rUBERn.Coordenada;
//import rUBERn.Buscador;
//import rUBERn.Viaje;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by Lucas on 20/10/2016.
// */
//public class BuscadorTest {
//    /**HACER PUBLICO LOS METODOS AUXILIARES */
//
//    Categoria cat1 = new Categoria("cat1", 250);
//    Auto car1 = new Auto("abs", "abs ", 2, cat1);
//    Chofer chofer1 = new Chofer("1",car1, 0, 0);
//
//    Categoria cat2 = new Categoria("cat2", 50);
//    Auto car2 = new Auto("abs", "abs ", 4, cat2);
//    Chofer chofer2 = new Chofer("2",car2, 0, 0);
//
//    Categoria cat3 = new Categoria("cat3", 150);
//    Auto car3 = new Auto("abs", "abs ", 6, cat3);
//    Chofer chofer3 = new Chofer("3",car3, 0, 0);
//
//
//    Coordenada coord1 = new Coordenada(0,0);
//    Coordenada coord2 = new Coordenada(2,2);
//    Viaje viaje = new Viaje(coord1,coord2,4);
//
//    @Test
//    public void FilterOnlineTest(){/*
//        ArrayList<Chofer> choferes = new ArrayList<>();
//        choferes.add(chofer1);
//        choferes.add(chofer2);
//        choferes.add(chofer3);
//
//        Buscador gestion = new Buscador(choferes);
//
//        choferes.get(1).setEstado(new Working()); // me aseguro descartar un elemento en el array auxiliar
//
//        ArrayList<Chofer> choferesTester = gestion.filterOnline(choferes);
//        assertTrue (choferesTester.contains(chofer1));
//
//        choferes.get(0).setEstado(new Working()); // como ejecuta el metodo seguro es Chofer1
//        choferesTester=gestion.filterOnline(choferes);
//
//        assertFalse(choferesTester.contains(chofer1));*/
//    }
//
//    @Test
//    public void FilterCapacityTester(){
//        ArrayList<Chofer> choferes = new ArrayList<>();
//        choferes.add(chofer1);
//        choferes.add(chofer2);
//        choferes.add(chofer3);
//
//        Buscador gestion = new Buscador(choferes);
//
//        ArrayList<Chofer> choferesTester = gestion.filterCapacity(viaje,choferes);
//
//        assertTrue(choferesTester.contains(chofer2));
//
//    }
//
//    @Test
//    public void sortByCostoDeImagenTest(){
//        ArrayList<Chofer> choferes = new ArrayList<>();
//        choferes.add(chofer1);
//        choferes.add(chofer2);
//        choferes.add(chofer3);
//
//        Buscador gestion = new Buscador(choferes);
//        ArrayList<Chofer> choferesTester = gestion.sortByCostoDeImagen(choferes,viaje);
//
//        assertTrue(chofer1.equals(choferesTester.get(2)));
//    }
//    @Test
//    public void sortByCostoDeImagenTestPorDistancia(){
//        ArrayList<Chofer> choferes = new ArrayList<>();
//
//        Categoria cat4 = new Categoria("cat1", 0);
//        Auto car4 = new Auto("abs", "abs ", 2, cat4);
//        Chofer chofer4 = new Chofer("4",car4, 5, 5);
//        Categoria cat5 = new Categoria("cat2", 0);
//        Auto car5 = new Auto("abs", "abs ", 4, cat5);
//        Chofer chofer5 = new Chofer("5",car5, 6, 6);
//        Categoria cat6 = new Categoria("cat3", 0);
//        Auto car6 = new Auto("abs", "abs ", 6, cat6);
//        Chofer chofer6 = new Chofer("6",car6, 2, 2);
//
//        choferes.add(chofer4);
//        choferes.add(chofer5);
//        choferes.add(chofer6);
//
//        Buscador gestion = new Buscador(choferes);
//        ArrayList<Chofer> choferesTester = gestion.sortByCostoDeImagen(choferes,viaje);
//        for (Chofer imprimir : choferesTester){
//            System.out.print(imprimir.getChoferCoordenas().getX()+"\n");
//        }
//        assertTrue(chofer6.equals(choferesTester.get(0)));
//    }
//}
