package com.example.eproject_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class emplyee_sign extends AppCompatActivity {

    TextInputLayout editTextname,editTextEmail, editTextPassword;
    Button btnsignup;
    TextView btnsignin;

    String url="https://talsa.000webhostapp.com/employee_register.php";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplyee_sign);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextname = findViewById(R.id.editTextname);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnsignup = findViewById(R.id.btnsignup);
        btnsignin=findViewById(R.id.btnsignin);

        ProgressDialog progressDialog=new ProgressDialog(emplyee_sign.this);

       progressDialog.setMessage("Loading");
        progressDialog.setTitle("Sign up");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);




        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                progressDialog.setCancelable(false);

                String updatedname = editTextname.getEditText().getText().toString().trim();
                String updatedemail = editTextEmail.getEditText().getText().toString().trim();
                String updatedpassword = editTextPassword.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(updatedname)) {
                    editTextname.setError("name is required");
                    return;
                }
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
                        Toast.makeText(emplyee_sign.this, "Registered successfully", Toast.LENGTH_SHORT).show();


//                       editTextname.setText("hello ");  editTextEmail.getEditText();
//                        editTextPassword.getEditText();
//
//                        Intent intent=new Intent(emplyee_sign.this,employee_account.class);
//                        startActivity(intent);
                        progressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(emplyee_sign.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }){
                    @Nullable

                    //if you want to save your work then make overside method in it
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                       Map<String,String> params=new HashMap<String,String>();
                       params.put("u_name",updatedname);
                       params.put("email",updatedemail);
                       params.put("password",updatedpassword);
                       return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(request);

            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(emplyee_sign.this,employee_account.class);
                startActivity(intent);
            }
        });
    }
}