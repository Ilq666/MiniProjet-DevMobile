package net.peyrache.marketplace.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.peyrache.marketplace.R;
import net.peyrache.marketplace.model.Fournisseur;

public class FournisseurPages extends AppCompatActivity {

    private BottomNavigationView bottomNavigationFo;
    private Fournisseur fournisseur;
    private Intent intentFo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisateur_fo_pages);
        init();
        bottomNavigationFo.setSelectedItemId(R.id.nav_home_fo);
    }

    private void init(){

        bottomNavigationFo=findViewById(R.id.container_items_bottom_fo);
        intentFo=getIntent();
        fournisseur = intentFo.getParcelableExtra("utilisateurFo");
        ecouteurBottomNavigationFo();
    }

    private void ecouteurBottomNavigationFo() {
        bottomNavigationFo.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment currentFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home_fo:
                        currentFragment = new Home_Fournisseur(fournisseur);
                        break;
                    case R.id.add:
                        currentFragment = new Add_Fournisseur(fournisseur);
                        break;
                    case R.id.profil_fo:
                        currentFragment = new Account_Fournisseur(fournisseur);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment_fo, currentFragment).commit();

                return true;
            }
        });
    }
}
