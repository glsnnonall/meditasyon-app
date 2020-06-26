package com.gulsum.onal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gulsum.onal.Helper.Utils;
import com.gulsum.onal.Menu.HoroscopeActivity;
import com.gulsum.onal.Menu.MeditaionMusicFragment;
import com.gulsum.onal.Menu.MusicPlayer;
import com.gulsum.onal.Menu.RecentFragment;

import java.util.HashMap;
import java.util.Map;

import okhttp3.internal.Util;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new RecentFragment()).commit();
            navigationView.setCheckedItem(R.id.recent);
        }
    }




    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.recent:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RecentFragment()).commit();
                break;
            case R.id.music:
              //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MeditaionMusicFragment()).commit();
                Intent i = new Intent(getApplicationContext(), MusicPlayer.class);
                startActivity(i);
                Utils.go(MainActivity.this);
                break;
            case R.id.mistik:

                Intent a = new Intent(getApplicationContext(), HoroscopeActivity.class);
                startActivity(a);
                Utils.go(MainActivity.this);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
      /*  CollectionReference ref = FirebaseFirestore.getInstance().collection("recentPost");
        Map<String,Object> map = new HashMap<>();
        map.put("title","Yas tutuyorsun, farkında mısın?");
        map.put("mainText","Zor Zamanlarda Ebeveynlik");
        map.put("mainText","");
        map.put("senderName","@rezzankiraz");
        map.put("profileImage","https://hthayat.haberturk.com/im/2015/03/18/ver1429277259/1028324_620x360.jpg");
        map.put("time", FieldValue.serverTimestamp());
        ref.add(map);*/

    }
}
