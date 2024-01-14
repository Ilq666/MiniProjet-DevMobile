package net.peyrache.marketplace.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.peyrache.marketplace.R;
import net.peyrache.marketplace.controller.CutilFournisseur;
import net.peyrache.marketplace.model.Article;
import net.peyrache.marketplace.model.Fournisseur;

import java.util.ArrayList;

public class Home_Fournisseur extends Fragment {

    private CutilFournisseur cutilFournisseur;
    private Fournisseur utilFo;
    private Home_UtilFo_ListAdapter home_utilFo_listAdapter;
    private ListView listViewArticle;
    private Fragment fragmentModifArticle;

    public Home_Fournisseur(Fournisseur utilFo){
        this.utilFo = utilFo;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fo, container, false);
        Context context = container.getContext();
        init(context, view);
        return view;
    }

    private void init(Context context, View view) {
        listViewArticle = view.findViewById(R.id.listViewArticles);
        cutilFournisseur = new CutilFournisseur(context);
        ArrayList<Article> listeArticle = (ArrayList<Article>) cutilFournisseur.listeArticle(utilFo.getnUtilisateur());

        home_utilFo_listAdapter = new Home_UtilFo_ListAdapter(context, listeArticle);
        listViewArticle.setAdapter(home_utilFo_listAdapter);

        ecouteurListViewArticle(context, view);
    }

    private void ecouteurListViewArticle(final Context context, View view) {
        listViewArticle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Récupération de l'objet article sur l'item cliqué par l'utilisateur

                Article article = (Article) listViewArticle.getItemAtPosition(position);
                fragmentModifArticle = new ModifArticle_Fournisseur(article, utilFo);
                getFragmentManager().beginTransaction().replace(R.id.container_fragment_fo, fragmentModifArticle).commit();
            }
        });
    }
}
