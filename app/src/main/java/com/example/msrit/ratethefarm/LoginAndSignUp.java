package com.example.msrit.ratethefarm;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAndSignUp extends AppCompatActivity {

    // Remove when project is done
    private Button mPage1, mPage2, mPage3, mPage4, mPage5;

    private FirebaseAuth mAuth;
    private Button login;
    private Button register;
    private EditText password;
    private EditText email;
    private ProgressDialog progressDialog;
    final static String TAG="Status";

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_sign_up);

        mPage1 = findViewById(R.id.page_1);
        mPage2 = findViewById(R.id.page_2);
        mPage3 = findViewById(R.id.page_3);
        mPage4 = findViewById(R.id.page_4);
        mPage5 = findViewById(R.id.page_5);

        mPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(v.getContext(), LoginAndSignUp.class);
                startActivity(myIntent);
            }
        });

        mPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), SignUp.class);
                startActivity(myIntent);
            }
        });


        mPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(v.getContext(), GetFarmerDetails.class);
                startActivity(myIntent);
            }
        });

        mPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), FarmersList.class);
                startActivity(myIntent);
            }
        });

        mPage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ShowFarmerDetails.class);
                startActivity(myIntent);
            }
        });




        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(LoginAndSignUp.this,FarmersList.class));
        }

        progressDialog = new ProgressDialog(this);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view==login)
                    userLogIn();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), SignUp.class);
                startActivity(myIntent);
            }
        });
    }


    @TargetApi(Build.VERSION_CODES.FROYO)
    private void userLogIn(){
        String mEmail=email.getText().toString().trim();
        String mPassword =password.getText().toString().trim();

        if (TextUtils.isEmpty(mEmail)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            email.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(mPassword)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return;
        }
        if (mPassword.length()<6){
            password.setError("Minimum length of password should be 6");
            password.requestFocus();
            return;
        }

        progressDialog.setMessage("Signing in...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Log.d(TAG,"SignInWithEmail:Success",task.getException());
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),FarmersList.class));
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(),task.getException().getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
