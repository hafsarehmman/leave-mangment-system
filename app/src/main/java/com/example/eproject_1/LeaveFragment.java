package com.example.eproject_1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class LeaveFragment extends Fragment {

ListView listView;
profileemployee_adapter profileemployeeAdapter;
    Profile_employee profile_employee;

public static ArrayList<Profile_employee> profile_employees=new ArrayList<>();

String url="https://talsa.000webhostapp.com/applyleaveview.php";

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
listView=v.findViewById(R.id.list_view);
        profileemployeeAdapter=new profileemployee_adapter(this,profile_employees);
        listView.setAdapter(profileemployeeAdapter);


retrivedata();
        return v;
    }

    private void retrivedata() {
    }
StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        profile_employees.clear();
try{
    JSONObject jsonObject=new JSONObject(response);
    String success=jsonObject.getString("success");
    JSONArray jsonArray=jsonObject.getJSONArray("data");

    if(success.equals("1")){
        for(int i=0; i<=jsonArray.length(); i++)
        {
            JSONObject object=jsonArray.getJSONObject(i);
            String id=object.getString("id");
            String noofdays=object.getString("numofday");
            String leavetype=object.getString("leavetype");
            String leavestatus=object.getString("leavestatus");
            profile_employee=new Profile_employee(Integer.parseInt(id),noofdays,leavetype,leavestatus);
            profile_employees.add(profile_employee);
            profileemployeeAdapter.notifyDataSetChanged();


        }
    }
}
catch (Exception e){

}
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
    }

}); }
//    RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//                requestQueue.add(request);
//}

