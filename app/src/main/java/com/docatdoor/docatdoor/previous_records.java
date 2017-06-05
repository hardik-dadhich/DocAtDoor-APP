package com.docatdoor.docatdoor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class previous_records extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_records);
    }
    public  void back()
    {
        Intent i=new Intent(this,AfterLogin.class);
        startActivity(i);
    }
}
