package Chofer.Estados;


import Chofer.Chofer;

public interface Estado {


    void goOnline();

    void goOffline();

    void working();

    boolean disponible();

}