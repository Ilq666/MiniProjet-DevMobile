package net.peyrache.marketplace.controller;

import android.content.Context;
import android.util.Log;

import net.peyrache.marketplace.model.Inscri_Client;
import net.peyrache.marketplace.model.inscri_Fournisseur;
import net.peyrache.marketplace.tools.DataBaseSqlLite;

public class CinscriptionActivity {

    private Inscri_Client inscriClient;
    private inscri_Fournisseur inscriFournisseur;
    private DataBaseSqlLite dataBaseSqlLite;
    private Context context;

    public CinscriptionActivity(Context context) {
        this.context= context;
    }

    /**
     * Récupération de la méthode de création d'inscription d'acheteur de l'outil sqLiteAccessRequest.
     * Elle sera réutilisé par l'activity InscriptionActivity pour la création d'un nouvel utilisateur de type "ac".
     * @param username
     * @param password
     * @param email
     * @param postalAddress
     * @param surname
     * @param name
     * @param sexe
     * @param rib
     */
    public void getInscriptionInstanceAc(String username, String password, String email,
                                         String postalAddress, String surname, String name, Integer sexe, String rib){
        //Ouverture d'un acces à la BDD
        dataBaseSqlLite = new DataBaseSqlLite(context);

        //Déclaration d'un objet InscritpionAc pour récupérer les données des
        // constantes disponible uniquement lors de l'instanciation de la classe.

        inscriClient = new Inscri_Client(username,password,email,postalAddress,surname,name,sexe,rib);
        dataBaseSqlLite.newUserAC(username, password, email, postalAddress, inscriClient.getType(), inscriClient.getPaiement(), sexe, surname, name, rib);
        dataBaseSqlLite.close();
    }

    /**
     * Récupération de la méthode de création d'inscription de fournisseur de l'outil sqLiteAccessRequest.
     * Elle sera réutilisé par l'activity InscriptionFoActivity pour la création d'un nouvel utilisateur de type "fo".
     * @param username
     * @param password
     * @param email
     * @param postalAddress
     * @param rib
     * @param raisonSociale
     */

    //Le constructeur entre une inscription de type ac et de type fo étant différent nous créons une autre méthode
    // pour créer un utilisateur de type "fo"

    public void getInscriptionInstanceFo(String username, String password, String email,
                                         String postalAddress, String rib, String raisonSociale){
        //Ouverture vers la base de données.
        dataBaseSqlLite = new DataBaseSqlLite(context);

        //Instanciation de la classe d'utilisateur de type fo.
        inscriFournisseur = new inscri_Fournisseur(username,password,email,postalAddress,rib, raisonSociale);

        //Test pour voir si les données transmises par l'objet inscriptionFo sont valides.
        Log.d("inscriptionFO type : ", "Username : "+username+" Password : "+password+" email : "+email+" Postal Address : "+postalAddress+" Type : "+ inscriFournisseur.getType()+" rib : "+rib+" Raison Sociale : "+raisonSociale);

        //Création d'une instance de la méthode newUserFO permettant de créer un utilisateur de type "fo".
        dataBaseSqlLite.newUserFO(username, password, email, postalAddress, inscriFournisseur.getType(), rib, raisonSociale);

        //Fermeture de la connexion à sqLiteAccessRequest.
        dataBaseSqlLite.close();
    }

    public Boolean utilExist(String username){

        dataBaseSqlLite = new DataBaseSqlLite(context);
        Boolean result = dataBaseSqlLite.utilExist(username);
        dataBaseSqlLite.close();

        return result;
    }

}