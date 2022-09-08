package com.example.mytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytask.databinding.ActivityInsideTheAppBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class InsideTheApp extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences sp_emails;
    SharedPreferences sp_names;
    ActivityInsideTheAppBinding binding;
    ActionBarDrawerToggle drawerToggle;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsideTheAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp_names = getSharedPreferences("name_file",MODE_PRIVATE);
        sp_emails = getSharedPreferences("email_file",MODE_PRIVATE);

        drawerToggle = new ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open,R.string.close);
        binding.drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        binding.navigation.setNavigationItemSelectedListener(this);


        Intent intent = getIntent();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId())
        {
            case R.id.nav_profile:
                Profile_Fragment profile_fragment = new Profile_Fragment();
                ft.replace(R.id.fragment_container,profile_fragment);
                ft.commit();
                return true;
            case R.id.nav_chat:
                Chat_fragment chat_fragment = new Chat_fragment();
                ft.replace(R.id.fragment_container,chat_fragment);
                ft.commit();
                return true;

            case R.id.nav_messageBox:
                MessageBox_Fragment messageBox_fragment = new MessageBox_Fragment();
                ft.replace(R.id.fragment_container,messageBox_fragment);
                ft.commit();
                return true;

            case R.id.nav_share:
                Share_Fragment share_fragment = new Share_Fragment();
                ft.replace(R.id.fragment_container,share_fragment);
                ft.commit();
                return true;

            case R.id.nav_send:
                Send_Fragment send_fragment = new Send_Fragment();
                ft.replace(R.id.fragment_container,send_fragment);
                ft.commit();
                return true;

            default:
                return false;
        }
    }
}