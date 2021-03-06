package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    public static String username = "adnan";
    public static String password = "Adonkey34";



    EditText usernameField;
    EditText passwordField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.setValue("Hello!");

        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
    }

    public void login(View view){
        String inputUsername = usernameField.getText().toString();
        String inputPassword = passwordField.getText().toString();

        if(username.equals(inputUsername) && password.equals(inputPassword)){
            Intent loginIntent = new Intent(this, MainActivity.class);
            startActivity(loginIntent);
        }
        else{
            Toast.makeText(this, "Your username or password were incorrect!", Toast.LENGTH_LONG).show();
        }
    }

    public void register(View view){
        Intent launchRegisterActivity = new Intent(this, RegisterActivity.class);
        startActivity(launchRegisterActivity);
    }
}