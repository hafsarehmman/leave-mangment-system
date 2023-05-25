package com.example.eproject_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dashboard_employee extends AppCompatActivity {

    FrameLayout frame_layout;
    DrawerLayout draw;
    ListView list;
    Toolbar my_tool;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_employee);

        my_tool=findViewById(R.id.my_tool);

        frame_layout=findViewById(R.id.frame_layout);
        draw=findViewById(R.id.draw);
         list=findViewById(R.id.list);

         ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,draw,my_tool,R.string.open,R.string.close);
        draw.setDrawerListener(toggle);
        toggle.syncState();

         list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 switch (i)
                 {
                     case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Applyeave_Fragment()).commit();
                         break;
                     case 1:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new LeaveFragment()).commit();
                         break;
                     case 2:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new TeamMemberFragment()).commit();
                         break;
                     case 3:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HolidayCalenderFragment()).commit();
                         break;
                     case 4:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new ProfileFragment()).commit();
                         break;
                     case 5:
                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new AnnouncementFragment()).commit();
                         break;
                     case 6:
                         SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                         SharedPreferences.Editor editor = preferences.edit();
                         editor.remove("islogin");
                         editor.commit();
                         finish();
                         Intent intent = new Intent(Dashboard_employee.this,employee_account.class);
                         startActivity(intent);
                         break;
                 }
                 draw.closeDrawers();
             }
         });

    }
}



