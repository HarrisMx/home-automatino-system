package com.example.cccosmo.posts;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private Button signin;
    private Button signup;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;

    //DatabaseHandler db;

    private FirebaseAuth mAuth;
    private  FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );

        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById( R.id.progress);

        signin = findViewById ( R.id.signin );
        signup = findViewById ( R.id.signup );
        email =  findViewById ( R.id.email );
        password =  findViewById ( R.id.password );

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(login.this, dashboard.class));
                }
            }
        };

        signin.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString();

                final String pass = password.getText().toString();

                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText( getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty( pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                mAuth.signInWithEmailAndPassword(Email, pass)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult> () {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        Toast.makeText(login.this, getString(R.string.error_invalid_password), Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(login.this, dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        } );

        signup.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent i = new Intent ( login.this , signup.class );
                startActivity(i);
            }
        } );
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}
