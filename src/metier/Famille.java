package metier;

import java.util.*;

public class Famille {

    /* propriétés privées */
    private int idFamille;
    private String libFamille;

    /* getters et setters */
    public int getIdFamille() {
        return idFamille;
    }
    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
    }
    public String getLibFamille() {
        return libFamille;
    }
    public void setLibFamille(String libFamille) {
        this.libFamille = libFamille;
    }
    
    public Famille(int idFamille, String libFamille) {
        /* Affectations */
        this.idFamille = idFamille;
        this.libFamille = libFamille;

    }



}
