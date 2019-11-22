package com.example.a3rdasignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText Username, Password;
    Button btnLogin;
    String User, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.editTextuser);
        Password = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.LoginButton);



        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        User = Username.getText().toString();
        Pass = Password.getText().toString();
        if (validate()) {
            if (User.equals("admin") && Pass.equals("admin")) {
                Toast.makeText(Login.this, "Username and Password is correct", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                Username.setError("username or password is incorrect");
                Username.requestFocus();
            }
        }

    }

    private boolean validate() {
        if (TextUtils.isEmpty(User)) {
            Username.setError("Please Enter Name");
            Username.requestFocus();
            return false;

        }
        if (TextUtils.isEmpty(Pass)) {
            Password.setError("Please Enter DoB");
            Password.requestFocus();
            return false;
        }
        return true;
    }
}
