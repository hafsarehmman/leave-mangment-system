package com.example.eproject_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class emp_adapter extends ArrayAdapter<Employee_users>{

   Context context;
   List<Employee_users> arraylist;
    public emp_adapter(@NonNull Context context, List<Employee_users> arraylist) {
        super(context, R.layout.fragment_profile, arraylist);

        this.context = context;
        this.arraylist = arraylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_profile,null,true);

        TextView textid=view.findViewById(R.id.textid);
        TextView textname=view.findViewById(R.id.textname);
        TextView textemail=view.findViewById(R.id.textemail);



        textid.setText(arraylist.get(position).getEmp_id());
        textname.setText(arraylist.get(position).getEmp_name());
        textemail.setText(arraylist.get(position).getEmp_email());

        return view;
    }

}
