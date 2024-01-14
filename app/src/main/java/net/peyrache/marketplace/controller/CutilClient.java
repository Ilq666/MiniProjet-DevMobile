package net.peyrache.marketplace.controller;

import android.content.Context;

import net.peyrache.marketplace.model.Article;
import net.peyrache.marketplace.model.Commande;
import net.peyrache.marketplace.tools.DataBaseSqlLite;

import java.util.ArrayList;

public class CutilClient {

    private Context context;
    private DataBaseSqlLite dataBaseSqlLite;

    public CutilClient(Context context){
        this.context=context;
    }

    public ArrayList<Article> listeBoutique(){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        ArrayList<Article> listArticles =(ArrayList<Article>) dataBaseSqlLite.affichageBoutique();
        dataBaseSqlLite.close();
        return listArticles;
    }

    public void ajoutCommande(Integer idUtilisateur, Integer nArticle, Float prixArticle, String nomArticle){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.ajoutCommande(idUtilisateur,nArticle,prixArticle, nomArticle);
        dataBaseSqlLite.close();
    }
    public Boolean stockSuffisant(Integer nArticle){
        Boolean stockSuffisant;
        dataBaseSqlLite = new DataBaseSqlLite(context);
        stockSuffisant = dataBaseSqlLite.stockSuffisant(nArticle);
        dataBaseSqlLite.close();
        return stockSuffisant;
    }

    public ArrayList<Commande> listeCommandes(Integer idUtilisateur){
        ArrayList<Commande> listeCommande;
        dataBaseSqlLite = new DataBaseSqlLite(context);
        listeCommande = (ArrayList<Commande>) dataBaseSqlLite.listeCommandes(idUtilisateur);
        dataBaseSqlLite.close();
        return  listeCommande;
    }
    public void supprLigneCommande(Integer idUtilisateur, Integer nArticle, Integer nCommande){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.supprLigneCommande(idUtilisateur, nArticle, nCommande);
        dataBaseSqlLite.close();
    }

    public String nomFournisseur(Integer nArticle){
        String nomFournisseur="";
        dataBaseSqlLite = new DataBaseSqlLite(context);
        nomFournisseur= dataBaseSqlLite.fournisseurArticle(nArticle);
        dataBaseSqlLite.close();
        return nomFournisseur;
    }
    public void supprToutesCommandes(ArrayList<Commande> listeCommande, Integer nUtilisateur){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.supprToutesCommandes(listeCommande, nUtilisateur);
        dataBaseSqlLite.close();
    }
    public void updateUtilAc(String username, String password, String adresse, String rib, String email){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.updateProfilAc(username,password,adresse,rib,email);
        dataBaseSqlLite.close();
    }
}
