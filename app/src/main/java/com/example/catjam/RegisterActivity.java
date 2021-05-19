package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    
    EditText username;
    EditText email;
    EditText password;
    EditText repeatPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.register_username);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        repeatPassword = findViewById(R.id.register_repeat_password);
    }
    
    public void register(View view){
        String inputPassword = password.getText().toString();
        String inputRepeatPassword = repeatPassword.getText().toString();
        
        if(inputPassword.equals(inputRepeatPassword)){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "You have successfully registered!", Toast.LENGTH_SHORT).show();
        }
    }

    public void yo(){

    }
}