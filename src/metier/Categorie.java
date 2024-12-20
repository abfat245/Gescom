package metier;

import java.util.*;

public class Categorie {

    /* propriétés privées */
    private int idCategorie;
    private String libCategorie;

    /* getters et setters */
    public int getIdCategorie() {
        return idCategorie;
    }
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    public String getLibCategorie() {
        return libCategorie;
    }
    public void setLibCategorie(String libCategorie) {
        this.libCategorie = libCategorie;
    }
    
    public Categorie(int idCategorie, String libCategorie) {
        /* Affectations */
        this.idCategorie = idCategorie;
        this.libCategorie = libCategorie;
    }


}
