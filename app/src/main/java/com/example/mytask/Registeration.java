package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.mytask.databinding.ActivityRegisterationBinding;

public class Registeration extends AppCompatActivity {

    ActivityRegisterationBinding binding;
    SharedPreferences sp_names;
    SharedPreferences sp_emails;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityRegisterationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = new Intent();

        sp_names = getSharedPreferences("name_file",MODE_PRIVATE);
        sp_emails = getSharedPreferences("email_file",MODE_PRIVATE);

        editor = sp_names.edit();
        editor2 = sp_emails.edit();

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString(binding.passwordReg.getText().toString(),binding.nameReg.getText().toString());
                editor.apply();
                Toast.makeText(getBaseContext(), binding.nameReg.getText().toString(), Toast.LENGTH_SHORT).show();

                editor2.putString(binding.passwordReg.getText().toString(),binding.emailReg.getText().toString());
                Toast.makeText(getBaseContext(), binding.emailReg.getText().toString(), Toast.LENGTH_SHORT).show();
                editor2.apply();

                setResult(1,intent);
                finish();
            }
        });


    }
}