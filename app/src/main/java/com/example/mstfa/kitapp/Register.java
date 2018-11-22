package com.example.mstfa.kitapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    Button btnSignUp;
    EditText txtEmailSignUp,txtPasswordSignUp,txtPasswordSignUpAgain;
    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmailSignUp = (EditText) findViewById(R.id.txtEmailSignUp);
        txtPasswordSignUp = (EditText) findViewById(R.id.txtPasswordSignUp);
        txtPasswordSignUpAgain = (EditText) findViewById(R.id.txtPasswordSignUpAgain);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddr = txtEmailSignUp.getText().toString();
                String pass = txtPasswordSignUp.getText().toString();
                String passAgain = txtPasswordSignUpAgain.getText().toString();
                 if(pass.equals(passAgain)){
                    firebaseAuth.createUserWithEmailAndPassword(emailAddr, pass)
                        .addOnSuccessListener(Register.this, new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(getApplicationContext(), "Register Successfull", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                }
                else{
                     Toast.makeText(Register.this, "Passwords Not Same", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
}
