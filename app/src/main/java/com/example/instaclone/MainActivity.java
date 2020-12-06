package com.example.instaclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instaclone.fragments.Friend_fragment;
import com.example.instaclone.fragments.Home_fragment;
import com.example.instaclone.fragments.Post_fragment;
import com.example.instaclone.fragments.Profil_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNav);
        Home_fragment home_fragment = new Home_fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, home_fragment).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = new Fragment();
                if (item.getItemId() == R.id.profil) {
                    Profil_fragment profil_fragment = new Profil_fragment();
                    selectedFragment = profil_fragment;
                }
                if (item.getItemId() == R.id.post) {
                    Post_fragment post_fragment = new Post_fragment();
                    selectedFragment = post_fragment;
                }
                if (item.getItemId() == R.id.friends) {
                    Friend_fragment friend_fragment = new Friend_fragment();
                    selectedFragment = friend_fragment;
                }
                if (item.getItemId() == R.id.home) {
                    Home_fragment home_fragment = new Home_fragment();
                    selectedFragment = home_fragment;
                }


                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                return true;

            }
        });
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {













        return super.onOptionsItemSelected(item);
    }*/
}