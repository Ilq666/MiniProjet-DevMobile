package net.peyrache.marketplace.controller;

import android.content.Context;

import net.peyrache.marketplace.model.Article;
import net.peyrache.marketplace.tools.DataBaseSqlLite;

import java.util.List;

public class CutilFournisseur {

//Définition des variables de classe.
private DataBaseSqlLite dataBaseSqlLite;
private Context context;

    //Constructeur de la classe CutilFo récupérant le context permettant l'instantiation de sqLiteAccessRequest.
    public CutilFournisseur(Context context){
        this.context = context;
    }

    //Permet l'update du profil utilisateur.
    public void modifUserFo(String username, String password, String email, String adresse, String rib, String raisonSociale){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.updateProfilFo(username, password, email, adresse, rib, raisonSociale);
        dataBaseSqlLite.close();
    }

    //Récupération des différentes catégories enregistré dans la base de données.
    public List<String> getAllLabels(){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        return dataBaseSqlLite.getAllLabels();
    }

    //Permet de récupérer une valeur booléenne pour savoir si l'article existe déjà ou non.
    /*public Boolean articleExistUneFoisModif(String nomArticle, Integer nUtilisateur){
        sqLiteAccessRequest = new SqLiteAccessRequest(context);
        Boolean exist = sqLiteAccessRequest.articleExistUneFoisModif(nomArticle, nUtilisateur);
        sqLiteAccessRequest.close();
        return exist;
    }*/
    public Boolean articleExist(String nomArticle, Integer nUtilisateur){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        Boolean exist = dataBaseSqlLite.articleExist(nomArticle, nUtilisateur);
        dataBaseSqlLite.close();
        return exist;
    }

    //Permet l'ajout de l'article. Prend en paramètre articleExist pour éviter les erreurs lors de l'utilisation de cette méthode.
    public void addArticle(Integer nUtilisateur, String cat, String nomArticle, String description, Float prix, Integer Qte, Boolean articleExist){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.articleAdd(nUtilisateur, cat, nomArticle, prix,  description, Qte, articleExist);
        dataBaseSqlLite.close();
    }

    public List<Article> listeArticle(Integer idUtilisateur){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        List<Article> listeArticle = dataBaseSqlLite.listeArticleAjoutUtilFo(idUtilisateur);
        dataBaseSqlLite.close();
        return listeArticle;
    }
    /*public Article rechercheArticle(String nomArticle, Integer idUtilisateur){
        sqLiteAccessRequest = new SqLiteAccessRequest(context);
        Article article = sqLiteAccessRequest.rechercheArticle(nomArticle, idUtilisateur);
        sqLiteAccessRequest.close();
        return article;
    }*/
    public void articleUpdate(String ancienNomArticle, String descriptionArticle, Float prix, Integer qte, Integer idUtilisateur){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        dataBaseSqlLite.articleUpdate(ancienNomArticle, descriptionArticle, prix, qte, idUtilisateur);
        dataBaseSqlLite.close();
    }
}
