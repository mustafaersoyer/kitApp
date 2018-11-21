package com.example.mstfa.kitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    Intent i;
    TextView txtViewSignUp;
    Button btnLogin;
    EditText txtEmail,txtPassword;
    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddr = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(emailAddr, pass)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Giriş Başarılı.", Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(getApplicationContext(),"Giriş Hatası!",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    public void txtViewSignUpClick(View view){
        i = new Intent(this,Register.class);
        startActivity(i);
    }
}
