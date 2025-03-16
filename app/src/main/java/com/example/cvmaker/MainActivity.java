package com.example.cvmaker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView ivLogo;
    Animation anim_fade_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent mainScreenIntent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(mainScreenIntent);
            finish();
        }, 5000);
    }

    private void init() {
        ivLogo = findViewById(R.id.ivLogo);
        anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_fade_in);
        ivLogo.setAnimation(anim_fade_in);
    }
}