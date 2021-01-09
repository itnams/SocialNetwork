package com.example.socialnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    TextView txtRegister,txtForgotpassword;
    EditText edtEmail,edtPass;
    private FirebaseAuth mAuth;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtRegister = findViewById(R.id.txtRegister);
        edtEmail =findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        txtForgotpassword = findViewById(R.id.txtForgotpassword);
        txtForgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Forgotpassword.class);
                startActivity(intent);
            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtEmail.getText().toString().equals("")||edtPass.getText().toString().equals(""))
                {
                    Toast.makeText(Login.this,"Login:failure" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    login();
                }

            }
        });
    }
    private void login()
    {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtPass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful())
                       {
                           Intent intent = new Intent(Login.this, home.class);
                           startActivity(intent);
                       }
                       else
                       {
                           Toast.makeText(Login.this, "Login:failure" + task.getException(), Toast.LENGTH_SHORT).show();
                       }
                    }
                });
    }
}