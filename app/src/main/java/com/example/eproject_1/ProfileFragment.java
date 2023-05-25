package com.example.eproject_1;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.collection.CircularArray;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ProfileFragment extends Fragment {

    public static ArrayList<Employee_users> userarraylist = new ArrayList<>();
    emp_adapter empAdapter;
    Employee_users employee_users;
    Button btnedit;

    // shared preference
    TextView textemail;
    ListView listView;
    String url = "https://talsa.000webhostapp.com/employee_view.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        // shared preference
        textemail = v.findViewById(R.id.textemail);
        listView = v.findViewById(R.id.list_view);
        btnedit=v.findViewById(R.id.btnedit);
        ArrayList<Employee_users> employeeUsersList = new ArrayList<>();
        empAdapter = new emp_adapter(requireContext(), employeeUsersList);

        // shared preference
        SharedPreferences getshare = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String value = getshare.getString("email", "demo@gmail.com");
        textemail.setText(value);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                ProgressDialog progressDialog = new ProgressDialog(view.getContext());
//
//                CharSequence[] items = {"Edit Record", "Delete Record"};
//
//                builder.setTitle((CharSequence) userarraylist.get(position));
//
//                builder.setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which) {
//                            case 0:
//                                Intent intent = new Intent(getContext(), profile_edit.class);
//                                int position = 0;
//                                intent.putExtra("emp_id", position);
//                                intent.putExtra("emp_name", position);
//                                intent.putExtra("emp_email", position);
//
//                                startActivity(intent);
//                                break;
//                        }
//                    }
//                });
//
//                builder.create().show();
//            }
//        });
      btnedit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(getContext(),profile_edit.class);
              startActivity(intent);
          }
      });


        // Request for data using Volley
//        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//               Intent intent = new Intent(requireContext(), profile_edit.class);
//              requireContext().startActivity(intent);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Handle the error here
//            }
//        });
//
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        requestQueue.add(request);
//
//






//        btnedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        if(response.equalsIgnoreCase("updated")){
//                            Toast.makeText(getContext(), "profile updated successfully", Toast.LENGTH_SHORT).show();
//
//                            Intent intent=new Intent(getContext(),profile_edit.class);
//                            startActivity(intent);
//                        }
//
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }){
//
//                };
//                RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//                requestQueue.add(request);
//
//            }
//        });
        return v;
    };}




















//    private void retrivedata (){

//@Override
//public void onResponse(String response){
//
//
//        try{
//        JSONObject jsonObject=new JSONObject(response);
//        String success=jsonObject.getString("success");
//        JSONArray jsonArray=jsonObject.getJSONArray("data");
//        if(success.equals("1")){
//
//        }
//        for(int i=0;i<jsonArray.length();i++){
//        JSONObject object=jsonArray.getJSONObject(i);
//        String id=object.getString("id");
//        String name=object.getString("name");
//        String email=object.getString("eamil");
//        employee_users=new Employee_users(id,name,email);
//        empAdapter.notifyDataSetChanged();
//        }
//
//        }catch(Exception e){
//
//        }
//        }
//        },new Response.ErrorListener(){
//@Override
//public void onErrorResponse(VolleyError error){
//        Toast.makeText(ProfileFragment.this,""+error.getContext(),Toast.LENGTH_SHORT).show();
//        }
//        });