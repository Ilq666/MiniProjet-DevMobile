package net.peyrache.marketplace.controller;

import android.content.Context;

import net.peyrache.marketplace.model.Client;
import net.peyrache.marketplace.model.Fournisseur;
import net.peyrache.marketplace.tools.DataBaseSqlLite;

public class CpageAccueil {
    private DataBaseSqlLite dataBaseSqlLite;
    //private UtilisateurAc utilisateur;
    private Context context;

    //Constructeur CpageAccueil retournant le contenu du constructeur Object.
    public CpageAccueil(Context context) {
        this.context=context;
    }

    /**
     * Permet de tester le type de l'utilisateur pour les conditions du MainActivity
     * (utilisé dans le main activity pour ses conditions)
     * @param username
     * @param password
     * @return
     */
    public String getTypeUser(String username, String password){
        dataBaseSqlLite = new DataBaseSqlLite(context);
        String verif = dataBaseSqlLite.verifTypeUser(username, password);
        dataBaseSqlLite.close();
        return verif;
    }

    /**
     * Récupération de l'objet utilisateur de type "acheteur" permettant l'accès à ses attributs.
     * @param username
     */
    public Client getConnexionAC(String username){

        //Ouverture d'une connexion à la base de données.
        dataBaseSqlLite = new DataBaseSqlLite(context);

        //Récupération de l'objet utilisateur de la méthode connexionAC de l'outil SqLiteAccessRequest
        Client utilisateur = dataBaseSqlLite.connexionAC(username);
        dataBaseSqlLite.close();
        return utilisateur;
    }
    /**
     * Récupération de l'objet utilisateur de type "fournisseur" permettant l'accès à ses attributs.
     * @param username
     */
    public Fournisseur getConnexionFO(String username){
        //Ouverture d'une connexion à la base de données.
        dataBaseSqlLite = new DataBaseSqlLite(context);

        Fournisseur user = dataBaseSqlLite.connexionFo(username);
        dataBaseSqlLite.close();
        return user;
    }
}

