package com.example.eproject_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class profileemployee_adapter extends ArrayAdapter<Profile_employee> {

    LeaveFragment context;
    List<Profile_employee> arraylist;

    public profileemployee_adapter(@NonNull LeaveFragment context, List<Profile_employee> arraylist) {
        super(context.getContext(), R.layout.fragment_profile, arraylist);

        this.context = context;
        this.arraylist = arraylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_leave, null, true);

        TextView textid = view.findViewById(R.id.textid);
        TextView textleavetype = view.findViewById(R.id.textleavetype);
        TextView textnoofdays = view.findViewById(R.id.textnoofdays);
        TextView leavestatus = view.findViewById(R.id.leavestatus);

        textid.setText(arraylist.get(position).getId());
        textleavetype.setText(arraylist.get(position).getLeave_type());
        textnoofdays.setText(arraylist.get(position).getNumber_of_days());

        return view;
    }
}
