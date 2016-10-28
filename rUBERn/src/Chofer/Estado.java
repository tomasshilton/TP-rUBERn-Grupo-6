package Chofer;


public  abstract class Estado {

    public abstract void goOnline();

    public abstract void goOffline();

    public abstract void work();

    public abstract boolean disponible();

}
