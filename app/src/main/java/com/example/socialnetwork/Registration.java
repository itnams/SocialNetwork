package com.example.socialnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class Registration extends AppCompatActivity {
 Spinner spinerGioitinh;
 EditText edtBirtday,edtEmail,edtPass,edtFullName;
 List<String> listGioiTinh;
 Button btnRegistration;
 TextView txtLogin;
 String gender;
 DatabaseReference mData;
 private FirebaseAuth mAuth;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edtBirtday = findViewById(R.id.edtBirtday);
        edtEmail = findViewById(R.id.edtEmail);
        txtLogin = findViewById(R.id.txtLogin);
        edtFullName = findViewById(R.id.edtFullName);
        btnRegistration = findViewById(R.id.btnRegistration);
        edtPass = findViewById(R.id.edtPass);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtBirtday.getText().toString().equals("")||edtEmail.getText().toString().equals("")||edtFullName.getText().toString().equals("")||edtPass.getText().toString().equals(""))
                {
                    Toast.makeText(Registration.this, "createUserWithEmail:failure", Toast.LENGTH_SHORT).show();
                }else
                {
                    registration();
                }
            }
        });
        listGioiTinh = new ArrayList<>();
        listGioiTinh.add("Nam");
        listGioiTinh.add("Nu");
        spinerGioitinh = (Spinner) findViewById(R.id.spinerGioitinh);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listGioiTinh);
        spinerGioitinh.setAdapter(spinnerAdapter);
        edtBirtday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date();
            }
        });
       spinerGioitinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               gender = listGioiTinh.get(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

    }
    private void date(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int mon = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,day);
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd/mm/yyyy");
                edtBirtday.setText(simpleFormatter.format(calendar.getTime()));
            }
        },year,mon,day);
        datePickerDialog.show();
    }
    private void registration(){
        mData = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(), edtPass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Account account = new Account(edtEmail.getText().toString(),edtFullName.getText().toString(),edtBirtday.getText().toString(),gender,mAuth.getUid());
                                mData.child("User").child(mAuth.getUid()).setValue(account);
                                Toast.makeText(Registration.this,"createUserWithEmail:success", Toast.LENGTH_SHORT).show();
                                finish();
                            }else
                            {
                                Toast.makeText(Registration.this, "createUserWithEmail:failure" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                    }
                });
    }
}