package com.example.cvmaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfilePicture extends AppCompatActivity {

    ImageView ivPicturePreview;
    Button btnSelectProfilePicture, btnCancelProfilePicture, btnSaveProfilePicture;
    ActivityResultLauncher<Intent> pickImageLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_picture);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSelectProfilePicture.setOnClickListener((v)->{
        });

        btnCancelProfilePicture.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });

        btnSaveProfilePicture.setOnClickListener((v)->{
        });

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                });
    }

    private void init(){
        btnSelectProfilePicture = findViewById(R.id.btnSelectProfilePicture);
        btnSaveProfilePicture = findViewById(R.id.btnSaveProfilePicture);
        btnCancelProfilePicture = findViewById(R.id.btnCancelProfilePicture);

        ivPicturePreview = findViewById(R.id.ivPicturePreview);
    }

}