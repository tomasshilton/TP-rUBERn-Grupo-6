package rUBERn;



public class Viaje {

    private Coordenada desde;
    private Coordenada destino;
    private double precio;
    private double distance;

    private int numberOfPassenger;

    public Viaje(Coordenada desde, Coordenada destino, int numberOfPassenger){
        this.desde=desde;
        this.destino=destino;
        calculateDistance();
        calculatePrecio();
        this.numberOfPassenger=numberOfPassenger;
    }

    private void calculateDistance(){
        distance = Math.sqrt(Math.pow(destino.getX()-desde.getX(),2.0)+Math.pow(destino.getY()-desde.getY(),2));
    }

    private void calculatePrecio(){
        if(distance<1500){
            precio = 15;
        }else{
        precio = distance/100;
        }
    }

    public double getDistance() {
        return distance;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumberOfPassenger(){
        return numberOfPassenger;
    }

    public void addAPassenger(){
        addPassengers(1);
    }

    public void addPassengers(int passangers){
        numberOfPassenger+=passangers;
    }

    public Coordenada getDestino() {
        return destino;
    }

    public Coordenada getDesde() {
        return desde;
    }
}
