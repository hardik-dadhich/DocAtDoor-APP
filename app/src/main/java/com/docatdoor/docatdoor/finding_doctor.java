package com.docatdoor.docatdoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class finding_doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_doctor);
    }

    public  void back()
    {
        Intent i=new Intent(this,AfterLogin.class);
        startActivity(i);
    }
}
