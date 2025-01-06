package gescom;

import metier.*;
import dao.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import metier.Client;
import metier.Commande;
import metier.Article;

import utilitaires.Outils;



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
     *
     * @param unRepresentant //
     */
    private static void afficherCaClient(Representant unRepresentant) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID du client : ");
        int idClient = sc.nextInt();

        Client client = unRepresentant.getClientById(idClient);
        if (client != null) {
            client.cumulCA();
            System.out.println("Chiffre d'affaire du client " + client.getRaisonSociale() + " : " + client.getCa());
        } else {
            System.out.println("Client inexistant");
        }
    }


    /**
     * Saisie de l'id du client à recherché, si trouvé
     * parcours de la liste des commande et pour chaque
     * commande, affiche la commande
     * sinon affiche client inexistant
     *
     * @param unRepresentant //
     */
    private static void afficherCommandesClient(Representant unRepresentant) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID du client : ");
        int idClient = sc.nextInt();

        Client client = unRepresentant.getClientById(idClient);
        if (client != null) {
            for (Commande commande : client.getLesCommandes()) {
                afficherCommande(commande);  // Afficher chaque commande du client
            }
        } else {
            System.out.println("Client inexistant");
        }
    }

    /**
     * Parcours de la liste des clients et pour chaque client
     * affiche son id et sa raison sociale, puis parcours de
     * la liste des commandes du client et affiche chaque
     * commande
     *
     * @param unRepresentant //
     */
    private static void listerClients(Representant unRepresentant) {
        for (Client client : unRepresentant.getLesClients()) {
            System.out.println("Client ID: " + client.getIdClient() + ", Raison Sociale: " + client.getRaisonSociale());
            for (Commande commande : client.getLesCommandes()) {
                afficherCommande(commande);
            }
        }
    }

    /**
     * Saisie du numéro de la commande à suprimer,
     * parcours de la liste de tous les clients, si la commande
     * est trouvée, la supprimer de la liste des commandes
     * de ce client et arrêter le parcours.
     *
     * @param unRepresentant //
     */
    private static void supprimerCommande(Representant unRepresentant) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID du client : ");
        int idClient = sc.nextInt();
        Client client = unRepresentant.getClientById(idClient);

        if (client != null) {
            System.out.println("Entrez l'ID de la commande à supprimer : ");
            int idCommande = sc.nextInt();
            Commande commande = client.getCommandeById(idCommande);

            if (commande != null) {
                client.supprimerCommande(commande);
                System.out.println("Commande supprimée.");
            } else {
                System.out.println("Commande inexistante.");
            }
        } else {
            System.out.println("Client inexistant.");
        }
    }

    /**
     * Affiche la liste des articles commandés sans doublons.
     * Déclare et instancie une collection d'Article
     * Parcours de la liste des clients et pour chaque client
     * parcours de la liste de ses commandes et pour chaque
     * commande parcours de la liste des lignes
     * Si la liste locale ne contient pas l'article de la ligne
     * en cours ,l'ajouter et afficher l'article
     *
     * @param unRepresentant //
     */
    private static void afficherArticlesCommandes(Representant unRepresentant) {
        Set<Article> articlesCommandes = new HashSet<>();
        for (Client client : unRepresentant.getLesClients()) {
            for (Commande commande : client.getLesCommandes()) {
                for (Ligne ligne : commande.getLesLignes()) {
                    articlesCommandes.add(ligne.getArticle());  // Ajouter l'article sans doublons
                }
            }
        }

        for (Article article : articlesCommandes) {
            afficherArticle(article);  // Afficher chaque article
        }

    }

    /**
     * Affiche l'id, la désignation, la famille et la TVA
     * de l'article passé en paramètre
     *
     * @param unArticle //
     */
    private static void afficherArticle(Article unArticle) {
        System.out.println("ID Article: " + unArticle.getIdArticle());
        System.out.println("Désignation: " + unArticle.getDesignation());
        System.out.println("Famille: " + unArticle.getUneFamille().getLibFamille());
        System.out.println("TVA: " + unArticle.getUneTva().getTauxTva() + "%");
    }

    /**
     * Parcours de la liste des clients et pour chaque client,
     * appel de la méthode cumulCA() et affichage de l'id
     * de la raison sociel et du CA du client
     *
     * @param unRepresentant//
     */
    private static void afficherCaClients(Representant unRepresentant) {
        for (Client client : unRepresentant.getLesClients()) {
            client.cumulCA();  // Calculer le CA du client
            System.out.println("Client ID: " + client.getIdClient() + ", Raison Sociale: " + client.getRaisonSociale());
            System.out.println("Chiffre d'affaire: " + client.getCa());
        }
    }

    /**
     * Recherche la commande d'un client.
     * saisie de l'id du client, récupération
     * du client, s'il existe : saisie de l'id
     * de la commande, récupération de la commande
     * si elle existe afficher la commande, sinon
     * afficher commande inexistante, idem pour
     * le client
     *
     * @param unRepresentant//
     */
    private static void rechercherCommande(Representant unRepresentant) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID du client : ");
        int idClient = sc.nextInt();
        Client client = unRepresentant.getClientById(idClient);

        if (client != null) {
            System.out.println("Entrez l'ID de la commande : ");
            int idCommande = sc.nextInt();
            Commande commande = client.getCommandeById(idCommande);

            if (commande != null) {
                afficherCommande(commande);  // Afficher la commande
            } else {
                System.out.println("Commande inexistante.");
            }
        } else {
            System.out.println("Client inexistant.");
        }
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
     *
     * @param unRepresentant//
     */
    private static void supprimerLigne(Representant unRepresentant) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID du client : ");
        int idClient = sc.nextInt();
        Client client = unRepresentant.getClientById(idClient);

        if (client != null) {
            System.out.println("Entrez l'ID de la commande : ");
            int idCommande = sc.nextInt();
            Commande commande = client.getCommandeById(idCommande);

            if (commande != null) {
                System.out.println("Entrez l'ID de l'article : ");
                int idArticle = sc.nextInt();
                Ligne ligne = commande.chercherLigne(idArticle, null);

                if (ligne != null) {
                    commande.supprimerLigne(ligne);
                    System.out.println("Ligne supprimée.");
                } else {
                    System.out.println("Article non trouvé dans cette commande.");
                }
            } else {
                System.out.println("Commande inexistante.");
            }
        } else {
            System.out.println("Client inexistant.");
        }
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
     *
     * @param unRepresentant/
     */
    private static void ajouterCommande(Representant unRepresentant) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID du client : ");
        int idClient = sc.nextInt();
        Client client = unRepresentant.getClientById(idClient);

        if (client != null) {
            System.out.println("Entrez l'ID de la commande : ");
            int idCommande = sc.nextInt();
            sc.nextLine();
            System.out.println("Entrez la date de la commande (yyyy-MM-dd) : ");
            String dateCommande = sc.nextLine();


            Commande commande = new Commande(idCommande, Outils.stringToDate(dateCommande));
            client.ajouterCommande(commande);

            boolean ajoutLigne = true;
            while (ajoutLigne) {
                System.out.println("Entrez l'ID de l'article : ");
                int idArticle = sc.nextInt();
                System.out.println("Entrez la quantité commandée : ");
                int qteCommande = sc.nextInt();
                Article article = bdd.getArticleBdD(idArticle);

                if (bdd != null) {
                    commande.ajouterLigne(article, qteCommande);
                } else {
                    System.out.println("Article non trouvé.");
                }

                System.out.println("Souhaitez-vous ajouter une autre ligne ? (oui/non) : ");
                String reponse = sc.next();
                if (!reponse.equalsIgnoreCase("oui")) {
                    ajoutLigne = false;
                }
            }

        } else {
            System.out.println("Client inexistant.");
        }
    }

    /**
     * Affiche l'id, la date de la commande,
     * puis affiche la liste des lignes : id article
     * désignation et qte commandée
     *
     * @param uneCommande/
     */
    private static void afficherCommande(Commande uneCommande) {
        System.out.println("ID de la commande : " + uneCommande.getIdCommande());
        System.out.println("Date de la commande : " + uneCommande.getDateCommande());


        if (uneCommande.getLesLignes() != null && !uneCommande.getLesLignes().isEmpty()) {
            System.out.println("Liste des lignes de commande :");


            for (Ligne ligne : uneCommande.getLesLignes()) {

                Article article = ligne.getArticle();


                System.out.println("ID Article: " + article.getIdArticle() +
                        " - Désignation: " + article.getDesignation() +
                        " - Quantité commandée: " + ligne.getQteCommande());
            }
        } else {
            System.out.println("Aucune ligne dans la commande.");
        }
    }
    public static void afficherArticleParId(int idArticle, List<Article> listeArticles) {

        for (Article unArticle : listeArticles) {
            if (unArticle.getIdArticle() == idArticle) {

                System.out.println("ID Article: " + unArticle.getIdArticle());
                System.out.println("Désignation: " + unArticle.getDesignation());
                System.out.println("Famille: " + unArticle.getUneFamille().getLibFamille());
                System.out.println("TVA: " + unArticle.getUneTva().getTauxTva() + "%");
                return;
            }
        }

        System.out.println("Article avec ID " + idArticle + " non trouvé.");
    }
}