package metier;

import java.util.*;
import metier.Categorie;

public class Client {

    /* propriétés privées */
    private int idClient;
    private String raisonSociale;
    private Categorie uneCategorie;
    private List<Commande> lesCommandes;  // Ajouté pour stocker les commandes
    private double ca;

    /* getters et setters */
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Categorie getUneCategorie() {
        return uneCategorie;
    }

    public void setUneCategorie(Categorie uneCategorie) {
        this.uneCategorie = uneCategorie;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }


    public Client(int idClient, String raisonSociale, Categorie uneCategorie) {
        /* Affectations */
        this.idClient = idClient;
        this.raisonSociale = raisonSociale;
        this.uneCategorie = uneCategorie;
        this.lesCommandes = new ArrayList<>();
        this.ca = 0.0;
    }

    /**
     * Ajoute une commande à la liste des commandes
     * du client. Prendre la précaution de vérifier
     * que la liste a bien été instanciée
     *
     * @param uneCommande
     */
    public void ajouterCommande(Commande uneCommande) {
        if (getLesCommandes() == null) {
            setLesCommandes(new ArrayList<Commande>());
        }
        if (!getLesCommandes().contains(uneCommande)) {
            this.lesCommandes.add(uneCommande);
        }
    }

    /**
     * Affecte la somme des valorisations des commandes
     * au CA du client. Prendre la précaution de
     * l'initialiser avant de commencer
     */
    public void cumulCA() {
        /* A compléter */
        double total = 0.0;
        for (Commande commande : lesCommandes) {
            total += commande.valoriserCommande();  // On ajoute la valeur de chaque commande
        }
        this.ca = total;
    }

    /**
     * Recherche une commande sur son numéro en
     * parcourant la liste des commandes, Retourne
     * une Commande si trouvée, sinon retourne null
     *
     * @param idCommande
     * @return Commande
     */
    public Commande getCommandeById(int idCommande) {
        for (Commande commande : lesCommandes) {
            if (commande.getIdCommande() == idCommande) {
                return commande;  // Retourne la commande si elle est trouvée
            }
        }
        return null;
    }

    /**
     * Retire une commande la liste des commandes.
     * Remarque : en supprimant une commande on supprime
     * aussi ses lignes (Composition)
     *
     * @param uneCommande
     */
    public void supprimerCommande(Commande uneCommande) {
        /* A compléter */
        if (lesCommandes != null && lesCommandes.contains(uneCommande)) {
            lesCommandes.remove(uneCommande);
        }
    }
}
