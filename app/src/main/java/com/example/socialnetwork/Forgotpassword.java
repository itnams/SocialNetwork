package com.example.socialnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgotpassword extends AppCompatActivity {
Button btnForgotpassword;
EditText edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        btnForgotpassword = findViewById(R.id.btnForgotpassword);
        edtEmail = findViewById(R.id.edtEmail);
        btnForgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtEmail.getText().toString().equals(""))
                {
                    Toast.makeText(Forgotpassword.this, "Forgot password:failure", Toast.LENGTH_SHORT).show();
                }
                else {
                    FirebaseAuth auth = FirebaseAuth.getInstance();

                    auth.sendPasswordResetEmail(edtEmail.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Forgotpassword.this,
                                                "Please check your email to get your password", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(Forgotpassword.this, "Failure" + task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}