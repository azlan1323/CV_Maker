package com.example.cvmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    Button btnProfilePicture, btnPersonalDetails, btnSummary, btnEducation, btnExperience;
    Button btnCertifications, btnReferences, btnPreviewScreen;
    ActivityResultLauncher<Intent> profilePictureLauncher, personalDetailsLauncher, summaryLauncher, educationLauncher;
    ActivityResultLauncher<Intent> experienceLauncher, certificationsLauncher, referencesLauncher;

    String experience, summary, education, references, certifications;
    String[] personalDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        //btnProfilePicture.setOnClickListener((v)-> launchProfilePictureActivity());
        btnSummary.setOnClickListener((v)-> launchSummaryActivity());
        btnExperience.setOnClickListener((v)-> launchExperienceActivity());
        btnEducation.setOnClickListener((v)-> launchEducationActivity());
        btnCertifications.setOnClickListener((v)-> launchCertificationsActivity());
        btnReferences.setOnClickListener((v)-> launchReferencesActivity());
        btnPersonalDetails.setOnClickListener((v)-> launchPersonalDetailsActivity());

        btnPreviewScreen.setOnClickListener((v)->{
            Intent intent = new Intent(HomeScreen.this, PreviewScreen.class);
            if (summary != null){
                intent.putExtra("SummaryDetails", summary);
                Log.d("SummaryDetails", summary);
            }
            if (experience != null){
                intent.putExtra("ExperienceDetails", experience);
                Log.d("ExperienceDetails", experience);
            }
            if (references != null) {
                intent.putExtra("ReferencesDetails", references);
                Log.d("ReferencesDetails", references);
            }
            if (certifications != null){
                intent.putExtra("CertificationsDetails", certifications);
                Log.d("CertificationsDetails", certifications);
            }
            if (education != null){
                intent.putExtra("EducationDetails", education);
                Log.d("EducationDetails", education);
            }
            if (personalDetails != null){
                intent.putExtra("PersonalDetails", personalDetails);
            }

            startActivity(intent);
            finish();
        });


        profilePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                    }
                }
        );

        summaryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null){
                            summary = data.getStringExtra("SummaryDetails");
                        }
                        else {
                            Log.d("summaryLauncher", "Data is empty.");
                        }
                    }
                }
        );

        educationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null){
                            education = data.getStringExtra("EducationDetails");
                        }
                        else {
                            Log.d("educationLauncher", "Data is empty.");
                        }
                    }
                }
        );

        experienceLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null){
                            experience = data.getStringExtra("ExperienceDetails");
                            runOnUiThread(() -> {
                                if (experience == null) {
                                    Toast.makeText(HomeScreen.this, "Experience NULL returned", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(HomeScreen.this, "experience", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else {
                            Log.d("experienceLauncher", "Data is empty.");
                            Toast.makeText(HomeScreen.this, "Data Empty.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        certificationsLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null){
                            certifications = data.getStringExtra("CertificationsDetails");
                        }
                        else {
                            Log.d("certificationsLauncher", "Data is empty.");
                        }
                    }
                }
        );

        referencesLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null){
                            references = data.getStringExtra("ReferencesDetails");
                        }
                        else {
                            Log.d("referencesLauncher", "Data is empty.");
                        }
                    }
                }
        );

        personalDetailsLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null){
                            personalDetails = data.getStringArrayExtra("PersonalDetails");
                        }
                        else {
                            Log.d("personalDetailsLauncher", "Data is empty.");
                        }
                    }
                }
        );
    }

    private void init() {
        btnProfilePicture = findViewById(R.id.btnProfilePicture);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnCertifications = findViewById(R.id.btnCertifications);
        btnReferences = findViewById(R.id.btnReferences);
        btnSummary = findViewById(R.id.btnSummary);
        btnPreviewScreen = findViewById(R.id.btnPreviewScreen);
    }

    private void launchProfilePictureActivity() {
        Intent intent = new Intent(HomeScreen.this, ProfilePicture.class);
        profilePictureLauncher.launch(intent);
    }

    private void launchSummaryActivity() {
        Intent intent = new Intent(HomeScreen.this, Summary.class);
        summaryLauncher.launch(intent);
    }

    private void launchExperienceActivity() {
        Intent intent = new Intent(HomeScreen.this, Experience.class);
        experienceLauncher.launch(intent);
    }

    private void launchReferencesActivity() {
        Intent intent = new Intent(HomeScreen.this, References.class);
        referencesLauncher.launch(intent);
    }

    private void launchCertificationsActivity() {
        Intent intent = new Intent(HomeScreen.this, Certifications.class);
        certificationsLauncher.launch(intent);
    }

    private void launchPersonalDetailsActivity() {
        Intent intent = new Intent(HomeScreen.this, PersonalDetails.class);
        personalDetailsLauncher.launch(intent);
    }

    private void launchEducationActivity() {
        Intent intent = new Intent(HomeScreen.this, Education.class);
        educationLauncher.launch(intent);
    }
}