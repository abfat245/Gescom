package metier;

import java.util.*;

public class Tva {

    /* propriétés privées */
    private int idTva;
    private double tauxTva;


    public Tva(int idTva, double tauxTva) {
        /* Affectations */
        this.idTva = idTva;
        this.tauxTva = tauxTva;
    }

    /* getters et setters */
    public int getIdTva() { return idTva; }
    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }
    public double getTauxTva() {
        return tauxTva;
    }
    public void setTauxTva(double tauxTva) {
        this.tauxTva = tauxTva;
    }

}
