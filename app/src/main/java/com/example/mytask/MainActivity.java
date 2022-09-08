package com.example.mytask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.mytask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp_emails;
    SharedPreferences sp_names;
    ActivityMainBinding binding;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp_names = getSharedPreferences("name_file",MODE_PRIVATE);

        sp_emails = getSharedPreferences("email_file",MODE_PRIVATE);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean is_password_exist = sp_emails.contains(binding.passwordReg.getText().toString());
                if (is_password_exist)
                {
                    Intent intent = new Intent(getBaseContext(),InsideTheApp.class);
                    intent.putExtra("password",binding.passwordReg.getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(), "This password is not correct, please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Registeration.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}