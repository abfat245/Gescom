package metier;

import java.util.*;
import metier.Article;
import metier.Commande;

public class Ligne {
   /* propriétés privées */
    private int qteCommande;
    private Article article;


    /* getters et setters */
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
    public int getQteCommande() {
        return qteCommande;
    }
    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    public Ligne(Article unArticle, int qteCommande) {
        this.article = unArticle;
        this.qteCommande = qteCommande;
    }
}