package com.example.eproject_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class employee_account extends AppCompatActivity {

    TextInputLayout editTextEmail, editTextPassword;
    Button btnsignin,forgetbtn,signInwithGoogle;
    TextView btnsignup;

    //signin with google
    FirebaseAuth auth;
    FirebaseDatabase database;
    GoogleSignInClient gsc;
    ProgressDialog progressDialog;


    String url="https://talsa.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_account);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnsignup = findViewById(R.id.btnsignup);
        btnsignin=findViewById(R.id.btnsignin);
        forgetbtn=findViewById(R.id.forgetbtn);

        //signin with google
        signInwithGoogle=findViewById(R.id.signInwithGoogle);
        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();

        if (getSharedPreferences("login", Context.MODE_PRIVATE).contains("islogin")) {
            Intent intent = new Intent(employee_account.this, Dashboard_employee.class);
            startActivity(intent);

        }else{

        }

        ProgressDialog progressDialog=new ProgressDialog(employee_account.this);

       progressDialog.setMessage("Loading");
        progressDialog.setTitle("Sign In");
       progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);

        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        gsc= GoogleSignIn.getClient(this,gso);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                progressDialog.setCancelable(false);

                String updatedemail = editTextEmail.getEditText().getText().toString().trim();
                String updatedpassword = editTextPassword.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(updatedemail)) {
                    editTextEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(updatedpassword)) {
                    editTextPassword.setError("Password is required");
                    return;
                }


                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        if(response.equalsIgnoreCase("success")){
                        Toast.makeText(employee_account.this, "Welcome", Toast.LENGTH_SHORT).show();


                            SharedPreferences share=getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor=share.edit();


                            editor.putString("email",updatedemail);

                            editor.apply();


                        Intent intent=new Intent(employee_account.this,Dashboard_employee.class);
                        startActivity(intent);

                        progressDialog.dismiss();
                        }
                        else{
                            Toast.makeText(employee_account.this,"Failed to login",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(employee_account.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){


                    //if you want to save your work then make overside method in it
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params=new HashMap<String,String>();

                        params.put("email",updatedemail);
                        params.put("password",updatedpassword);
                        return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(request);

            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(employee_account.this,emplyee_sign.class);
                startActivity(intent);
            }
        });

        //sign Inwith google

        signInwithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInwithGoogle();
            }
        });

    }

    int RC_SIGN_IN=40;
    private void signInwithGoogle() {

        Intent intent=gsc.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//if request code is equal to RC_SIGN_IN so you run if condition
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void firebaseAuth (String IdToken) {
        AuthCredential credential= GoogleAuthProvider.getCredential(IdToken,null);
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user=auth.getCurrentUser();

                    Users users=new Users();
                    users.setUserid(user.getUid());
                    users.setName(user.getDisplayName());
                    users.setProfile(user.getPhotoUrl().toString());
                    database.getReference().child("Users").child(user.getUid()).setValue(users);
                    Intent intent = new Intent(employee_account.this, Dashboard_employee.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(employee_account.this, "Error In SignIn", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}