package gescom;

import metier.*;
import dao.*;
import java.util.Scanner;
import utilitaires.*;

public class Gescom {

    /* Déclaration de l'objet de type BdD */
    static BdD bdd;
    public static void main(String[] args) {
        /* Instanciation de l'objet de type BdD */
        bdd = new BdD();
        /* Déclaration et instanciation d'un objet de type Representant */
        Representant unRepresentant = new Representant(100, "Paul", "Auchon", bdd.getClientsBdD());
        int choix = menu();
        while (choix != 0) {
            switch (choix) {
                case 1:
                    listerClients(unRepresentant);
                    break;
                case 2:
                    afficherArticlesCommandes(unRepresentant);
                    break;
                case 3:
                    rechercherCommande(unRepresentant);
                    break;
                case 4:
                    ajouterCommande(unRepresentant);
                    afficherCommandesClient(unRepresentant);
                    break;
                case 5:
                    supprimerCommande(unRepresentant);
                    listerClients(unRepresentant);
                    break;
                case 6:
                    supprimerLigne(unRepresentant);
                    break;
                case 7:
                    afficherCaClient(unRepresentant);
                    break;
                case 8:
                    afficherCaClients(unRepresentant);
                    break;
            }
            choix = menu();
        }
    }

    private static int menu() {
        System.out.println("Menu général");
        System.out.println();
        System.out.println("1..Lister les clients et leurs commandes");
        System.out.println("2..Liste des articles commandés");
        System.out.println("3..Rechercher une commande");
        System.out.println("4..Ajouter une commande");
        System.out.println("5..Supprimer une commande");
        System.out.println("6..Supprimer une ligne d'une commande");
        System.out.println("7..Afficher le CA d'un client");
        System.out.println("8..Afficher le CA de tous les clients");

        System.out.println("0..Quitter");
        Scanner sc = new Scanner(System.in);
        System.out.println("Votre choix : ");
        int choix = sc.nextInt();
        return choix;
    }

    /**
     * Saisie de l'id du client à recherché, si trouvé
     * calcul et affichage du CA du client
     * sinon affiche client inexistant
     * @param unRepresentant 
     */
    private static void afficherCaClient(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Saisie de l'id du client à recherché, si trouvé
     * parcours de la liste des commande et pour chaque
     * commande, affiche la commande
     * sinon affiche client inexistant
     * @param unRepresentant 
     */
    private static void afficherCommandesClient(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Parcours de la liste des clients et pour chaque client
     * affiche son id et sa raison sociale, puis parcours de
     * la liste des commandes du client et affiche chaque
     * commande
     * @param unRepresentant 
     */
    private static void listerClients(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Saisie du numéro de la commande à suprimer,
     * parcours de la liste de tous les clients, si la commande  
     * est trouvée, la supprimer de la liste des commandes 
     * de ce client et arrêter le parcours.
     * @param unRepresentant 
     */
    private static void supprimerCommande(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Affiche la liste des articles commandés sans doublons.
     * Déclare et instancie une collection d'Article
     * Parcours de la liste des clients et pour chaque client
     * parcours de la liste de ses commandes et pour chaque 
     * commande parcours de la liste des lignes
     * Si la liste locale ne contient pas l'article de la ligne
     * en cours ,l'ajouter et afficher l'article
     * @param unRepresentant 
     */
    private static void afficherArticlesCommandes(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Affiche l'id, la désignation, la famille et la TVA
     * de l'article passé en paramètre
     * @param unArticle 
     */
    private static void afficherArticle(Article unArticle) {
        /* A compléter */
    }

    /**
     * Parcours de la liste des clients et pour chaque client, 
     * appel de la méthode cumulCA() et affichage de l'id
     * de la raison sociel et du CA du client
     * @param unRepresentant 
     */
    private static void afficherCaClients(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Recherche la commande d'un client.
     * saisie de l'id du client, récupération
     * du client, s'il existe : saisie de l'id
     * de la commande, récupération de la commande
     * si elle existe afficher la commande, sinon 
     * afficher commande inexistante, idem pour 
     * le client
     * @param unRepresentant 
     */
    private static void rechercherCommande(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Supprimer une ligne de commande :
     * Saisie de l'id du client et récupération du client
     * S'il n'existe pas afficher client inexistant, 
     * s'il existe : saisie de l'id de la commande
     * récupération de la commande, si elle n'existe pas
     * afficher commande inexistante, si elle existe
     * saisie de l'id de l'article, rechercher la ligne
     * ayant l'id de l'article, si la ligne existe la supprimer
     * sinon afficher que l'article ne figure pas dans cette commande
     * @param unRepresentant 
     */
    private static void supprimerLigne(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Ajoute une commande à un client.
     * Saisie de l'id du client et recherche du client
     * S'il nexiste pas afficher client inexistant
     * S'il existe : saisie de l'id et de la date de commande
     * création de la commande et ajout à la liste des 
     * commandes du client, saisie de l'id de l'article
     * et de la qte commandée, ajout de la ligne à la
     * commande
     * Rappel : la classe bdd propose une méthode de recherche d'un article sur son id
     * @param unRepresentant 
     */
    private static void ajouterCommande(Representant unRepresentant) {
        /* A compléter */
    }

    /**
     * Affiche l'id, la date de la commande,
     * puis affiche la liste des lignes : id article
     * désignation et qte commandée
     * @param uneCommande 
     */
    private static void afficherCommande(Commande uneCommande) {
        /* A compléter */
    }

}
