/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import metier.*;
import utilitaires.*;

public class BdD {

    private List<Client> nosClients;
    private List<Commande> nosCommandes;
    private List<Article> nosArticles;
    private List<Tva> nosTva;
    private List<Famille> nosFamilles;
    private List<Categorie> nosCategories;

    public BdD() {
        chargerBdD();
    }

    /**
     * Charge les liste de clients, 
     * de commandes, de tva, de familles, 
     * de catégories, et d'articles
     */
    private void chargerBdD() {
        chargerTvas();
        chargerCategories();
        chargerFamilles();
        chargerArticles();
        chargerCommandes();
        chargerClients();
    }

    /**
     * Retourne la liste des clients
     *
     * @return List<Client>
     */
    public List<Client> getClientsBdD() {
        return nosClients;
    }

    /**
     * Recherche un article dans la base 
     * de données si trouvé, retourne
     * l'article, sinon retourne null
     *
     * @param idArticle
     * @return
     */
    public Article getArticleBdD(int idArticle) {
        Article articleATrouver = null;
        for (Article unArticle : nosArticles) {
            if (unArticle.getIdArticle() == idArticle) {
                articleATrouver = unArticle;
                break;
            }
        }
        return articleATrouver;
    }

    private void chargerTvas() {
        nosTva = new ArrayList<Tva>();
        Tva uneTva = new Tva(1, 20.0);
        nosTva.add(uneTva);
        uneTva = new Tva(2, 5.5);
        nosTva.add(uneTva);
    }

    private void chargerCategories() {
        nosCategories = new ArrayList<Categorie>();
        Categorie uneCategorie = new Categorie(10, "Particulier");
        nosCategories.add(uneCategorie);
        uneCategorie = new Categorie(20, "Revendeur");
        nosCategories.add(uneCategorie);
    }

    private void chargerFamilles() {
        nosFamilles = new ArrayList<Famille>();
        Famille uneFamille = new Famille(1, "VTT");
        nosFamilles.add(uneFamille);
        uneFamille = new Famille(2, "Accessoire");
        nosFamilles.add(uneFamille);
    }

    private void chargerArticles() {
        nosArticles = new ArrayList<Article>();
        Article unArticle = new Article(100, "VTT montagne", 130, 450.0, nosTva.get(0), nosFamilles.get(0));
        nosArticles.add(unArticle);
        unArticle = new Article(101, "VTT plaine", 120, 350.0, nosTva.get(0), nosFamilles.get(0));
        nosArticles.add(unArticle);
        unArticle = new Article(102, "VTT femme", 110, 250.0, nosTva.get(0), nosFamilles.get(0));
        nosArticles.add(unArticle);
        unArticle = new Article(103, "VTT homme", 100, 250.0, nosTva.get(0), nosFamilles.get(0));
        nosArticles.add(unArticle);
        unArticle = new Article(104, "Casque adulte", 90, 50.0, nosTva.get(1), nosFamilles.get(1));
        nosArticles.add(unArticle);
        unArticle = new Article(105, "Casque enfant", 80, 45.0, nosTva.get(1), nosFamilles.get(1));
        nosArticles.add(unArticle);
    }

    private void chargerCommandes() {
        nosCommandes = new ArrayList<Commande>();
        Commande uneCommande = new Commande(1000, Outils.stringToDate("01/04/2015"));
        uneCommande.ajouterLigne(nosArticles.get(0), 4);
        uneCommande.ajouterLigne(nosArticles.get(1), 5);
        uneCommande.ajouterLigne(nosArticles.get(2), 3);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1001, Outils.stringToDate("02/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(3), 6);
        uneCommande.ajouterLigne(nosArticles.get(4), 3);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1002, Outils.stringToDate("03/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(5), 4);
        uneCommande.ajouterLigne(nosArticles.get(1), 5);
        uneCommande.ajouterLigne(nosArticles.get(0), 3);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1003, Outils.stringToDate("04/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(3), 6);
        uneCommande.ajouterLigne(nosArticles.get(2), 3);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1004, Outils.stringToDate("04/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(1), 4);
        uneCommande.ajouterLigne(nosArticles.get(4), 1);
        uneCommande.ajouterLigne(nosArticles.get(0), 14);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1005, Outils.stringToDate("04/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(1), 15);
        uneCommande.ajouterLigne(nosArticles.get(2), 13);
        uneCommande.ajouterLigne(nosArticles.get(3), 16);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1006, Outils.stringToDate("05/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(4), 13);
        uneCommande.ajouterLigne(nosArticles.get(5), 14);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1007, Outils.stringToDate("05/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(3), 15);
        uneCommande.ajouterLigne(nosArticles.get(0), 13);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1008, Outils.stringToDate("05/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(3), 16);
        uneCommande.ajouterLigne(nosArticles.get(2), 13);
        uneCommande.ajouterLigne(nosArticles.get(1), 14);
        nosCommandes.add(uneCommande);

        uneCommande = new Commande(1009, Outils.stringToDate("06/05/2015"));
        uneCommande.ajouterLigne(nosArticles.get(0), 11);
        nosCommandes.add(uneCommande);
    }

    private void chargerClients() {
        nosClients = new ArrayList<Client>();
        Client unClient = new Client(100, "Paul Auchon", nosCategories.get(0));
        unClient.ajouterCommande(nosCommandes.get(0));
        unClient.ajouterCommande(nosCommandes.get(1));
        nosClients.add(unClient);

        unClient = new Client(101, "Annie Zhette", nosCategories.get(0));
        unClient.ajouterCommande(nosCommandes.get(2));
        nosClients.add(unClient);

        unClient = new Client(102, "Vélocipède 69", nosCategories.get(1));
        unClient.ajouterCommande(nosCommandes.get(3));
        unClient.ajouterCommande(nosCommandes.get(4));
        nosClients.add(unClient);

        unClient = new Client(103, "Vélocipède 38", nosCategories.get(1));
        unClient.ajouterCommande(nosCommandes.get(5));
        unClient.ajouterCommande(nosCommandes.get(6));
        nosClients.add(unClient);

        unClient = new Client(104, "La bicyclette d'or", nosCategories.get(1));
        unClient.ajouterCommande(nosCommandes.get(7));
        unClient.ajouterCommande(nosCommandes.get(8));
        nosClients.add(unClient);

        unClient = new Client(105, "Le vélo magique", nosCategories.get(1));
        unClient.ajouterCommande(nosCommandes.get(9));
        nosClients.add(unClient);
    }
}
