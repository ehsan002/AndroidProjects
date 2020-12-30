package com.ehsanrc.boipoka.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ehsanrc.boipoka.R;

public class Register extends AppCompatActivity {

    EditText et_name;
    EditText et_email;
    EditText et_password;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_name = (EditText) findViewById(R.id.et_regName);
        et_email = (EditText) findViewById(R.id.et_regEmail);
        et_password = (EditText) findViewById(R.id.et_regPW);
        btn_submit = (Button) findViewById(R.id.btn_regSubmit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),et_name.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
