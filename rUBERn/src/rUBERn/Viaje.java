package rUBERn;

/**
 * Created by Simon on 10/10/2016.
 */
public class Viaje {

    private Coordenada desde;
    private Coordenada hasta;
    private double precio;

    public Viaje(Coordenada desde, Coordenada hasta){
        this.desde=desde;
        this.hasta=hasta;
    }

    public double getDistance(){
        return Math.sqrt(Math.pow(hasta.getX()-desde.getX(),2.0)+Math.pow(hasta.getY()-desde.getY(),2));
    }



}
