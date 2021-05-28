package com.example.catjam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    
    EditText username;
    EditText email;
    EditText password;
    EditText repeatPassword;
    // Write a message to the database

    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.register_username);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        repeatPassword = findViewById(R.id.register_repeat_password);



    }
    
    public void register(View view) {
        String inputUsername = username.getText().toString();
        String inputEmail = email.getText().toString();
        String inputPassword = password.getText().toString();
        String inputRepeatPassword = repeatPassword.getText().toString();

        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        if (inputPassword.equals(inputRepeatPassword)) {
            mDatabase.child(inputUsername).setValue(new User(inputUsername,inputPassword,inputEmail));
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "You have successfully registered!", Toast.LENGTH_SHORT).show();
        }
    }
}