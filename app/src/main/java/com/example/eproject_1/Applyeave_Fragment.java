package com.example.eproject_1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Applyeave_Fragment extends Fragment {
    String url="https://talsa.000webhostapp.com/apply_leave.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_applyeave_, container, false);
      RadioButton causal,privilage,sick;
        TextView tv_selectdate;
        EditText et_selectdate;


        EditText numberofdays=v.findViewById(R.id.numberofdays);
        EditText reason=v.findViewById(R.id.reason);
        causal=v.findViewById(R.id.casual_leave);
        sick=v.findViewById(R.id.sick_leave);
        privilage=v.findViewById(R.id.privilege_leave);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button applybtn=v.findViewById(R.id.ApplyButton);
        tv_selectdate=v.findViewById(R.id.tv_selectdate);
        et_selectdate=v.findViewById(R.id.et_selectdate);
        final Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        tv_selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                    month =month+1;
                    String date=day+"/"+month+"/"+year;
                    tv_selectdate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        et_selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        month =month+1;
                        String date=day+"/"+month+"/"+year;
                        et_selectdate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatednumofdays=numberofdays.getText().toString();
                String updatedreason=reason.getText().toString();
                String updatedcausal=causal.getText().toString();
                String updatedsick=sick.getText().toString();
                String updatedprivilage=privilage.getText().toString();
                String updatedtvselecteddate=tv_selectdate.getText().toString();
                String updatedetselecteddate=et_selectdate.getText().toString();
//                int employeeid=3;

                String leavedata=updatedcausal+updatedprivilage+updatedsick;
                String datework=updatedtvselecteddate+updatedetselecteddate;


                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getContext(), "leave submitted succesfully", Toast.LENGTH_SHORT).show();
                        numberofdays.setText("");
                        reason.setText("");
                        tv_selectdate.setText("");
                        et_selectdate.setText("");


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params=new HashMap<String,String>();
                        params.put("numberofdays",updatednumofdays);
                        params.put("description",updatedreason);
                        params.put("leavetype",leavedata);
                        params.put("leavedate",datework);

                        return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getContext());
                requestQueue.add(request);
            }
        });
        return v;
    }
}