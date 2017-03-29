package com.project.lianda.hijabstylestore;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.lianda.hijabstylestore.UI.Katalog;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked())
                    menuItem.setChecked(false);
                else
                    menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.navigation1:
                        Toast.makeText(getApplicationContext(), "Ini Beranda", Toast.LENGTH_SHORT)
                                .show();
                        return true;

                    case R.id.navigation2:
                        Intent intent = new Intent(getApplicationContext(), Katalog.class);
                        startActivity(intent);
                        return true;

                    case R.id.navigation3:
                        Toast.makeText(getApplicationContext(), "Lihat belanjaan anda", Toast.LENGTH_SHORT)
                                .show();
                        return true;
                }

                return false;
            }
        });

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_main);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.OpenDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerClosed (View drawerView){
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
