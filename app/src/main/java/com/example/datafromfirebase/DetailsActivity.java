package com.example.datafromfirebase;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.datafromfirebase.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();


        binding.name.setText("Name : "+intent.getStringExtra("name"));
        binding.bio.setText("Bio : \n"+intent.getStringExtra("bio"));
        binding.id.setText("Id : " + intent.getStringExtra("id"));
        binding.version.setText("Version : "+intent.getStringExtra("version"));
        binding.language.setText("Language : "+ intent.getStringExtra("language"));

    }
}