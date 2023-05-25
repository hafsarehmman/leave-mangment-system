package com.example.eproject_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class profile_edit extends AppCompatActivity {

    String url="https://talsa.000webhostapp.com/profileemployee.php";
   String url1="https://talsa.000webhostapp.com/emp_image.php";

    EditText textname,textjoiningdate,textmanager;
//    int pos_id;
   Button btnupdate;

    //volleyimage
    ImageView imageView;
    FloatingActionButton floatingActionButton,upload_image;
    Bitmap bitmap;
    String encodeimage;

   @SuppressLint("MissingInflatedId")
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        textname=findViewById(R.id.textname);
        textjoiningdate=findViewById(R.id.textjoiningdate);
        textmanager=findViewById(R.id.textmanager);
        btnupdate=findViewById(R.id.btnupdate);
//volleyimage
        imageView=findViewById(R.id.imageView);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        upload_image=findViewById(R.id.upload_image);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(profile_edit.this ).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"select Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request =new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(profile_edit.this, response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(profile_edit.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params=new HashMap<>();
                    params.put("image",encodeimage);
                        return params;
                    }
                };
                RequestQueue queue=Volley.newRequestQueue(profile_edit.this);
                queue.add(request);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String updatedname = textname.getText().toString();
                String updatedmanager = textmanager.getText().toString();
                String updatedjoiningdate = textjoiningdate.getText().toString();

                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("updated")){
                            Toast.makeText(profile_edit.this, "profile updated successfully", Toast.LENGTH_SHORT).show();
                        textname.setText("");
                        textjoiningdate.setText("");
                        textmanager.setText("");

//                        Intent intent=new Intent(profile_edit.this,ProfileFragment.class);
//                        startActivity(intent);
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(profile_edit.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }){
                    @Nullable

                    //if you want to save your work then make overside method in it
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params=new HashMap<String,String>();

                        params.put("profilename",updatedname);
                        params.put("joiningdate",updatedjoiningdate);
                        params.put("managername",updatedmanager);
                        return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(request);

            }
        });
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
       if(requestCode==1 && resultCode== RESULT_OK && data!=null){

           Uri filepah=data.getData();
           try {
               InputStream stream=getContentResolver().openInputStream(filepah);
                bitmap= BitmapFactory.decodeStream(stream);
                imageView.setImageBitmap(bitmap);
               imagestore(bitmap);

           } catch (FileNotFoundException e) {
               throw new RuntimeException(e);
           }

       }

        super.onActivityResult(requestCode, resultCode, data);

    }
    private void imagestore(Bitmap bitmap){
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] imagebytes=stream.toByteArray();
        encodeimage=android.util.Base64.encodeToString(imagebytes, Base64.DEFAULT);
    }
}