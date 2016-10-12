package rUBERn;



public class Viaje {

    private Coordenada desde;
    private Coordenada hasta;
    private double precio;
    private double distance;

    private int numberOfPassenger=1;

    public Viaje(Coordenada desde, Coordenada hasta){
        this.desde=desde;
        this.hasta=hasta;
        calculateDistance();
        calculatePrecio();
    }

    private void calculateDistance(){
        distance = Math.sqrt(Math.pow(hasta.getX()-desde.getX(),2.0)+Math.pow(hasta.getY()-desde.getY(),2));
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

}
