package com.example.eproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class account1 extends AppCompatActivity {

    Button employee_account1,manager_account2,admin_account3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account1);
        employee_account1=findViewById(R.id.employee_account1);
        manager_account2=findViewById(R.id.manager_account2);
        admin_account3=findViewById(R.id.admin_account3);

        employee_account1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account1.this,employee_account.class);
                Intent intent1 = new Intent(account1.this,Manager_signin.class);
                startActivity(intent);
                startActivity(intent1);
            }
        });

    }
}