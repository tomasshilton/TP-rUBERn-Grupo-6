package rUBERn;

/**
 * Created by Simon on 10/10/2016.
 */
public class Viaje {

    private double[] ubicacion;
    private double[] destino;

    public Viaje(double[] ubicacion, double[] destino){
        this.ubicacion=ubicacion;
        this.destino=destino;
    }

    public double getDistance(){
        double ret = Math.sqrt(Math.pow(destino[0]-ubicacion[0],2.0)+Math.pow(destino[1]-ubicacion[1],2));
        return ret;
    }

}
