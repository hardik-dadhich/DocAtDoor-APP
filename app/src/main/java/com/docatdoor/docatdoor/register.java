package com.docatdoor.docatdoor;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class register extends Activity {

    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = (EditText) findViewById(R.id.UserNameEditText);
        e1 = (EditText) findViewById(R.id.PasswordEditText);
        b1 = (Button) findViewById(R.id.submitButton);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String text = e1.getText().toString();
                String text1=e2.getText().toString();
//                String Student_name=name.getText().toString();

    //            String Section=section.getText().toString();
       ///         String Email_Id=email.getText().toString();
  ///              String Contact=contact.getText().toString();
                if(text.isEmpty()){e1.setError("Please Enter Name");}else {e1.setError(null);}

                if(text1.isEmpty()){e2.setError("write password");}else {e2.setText(null);}
              /*  if(Email_Id.isEmpty()){email.setError("Please Enter Email Id");}else {email.setError(null);}
                if(Contact.isEmpty()){contact.setError("Please Enter Contact no.");}else {contact.setError(null);}*/
                if(!text.isEmpty()&&!text1.isEmpty()) {
                    Firebase ref = new Firebase("https://docatdoor-e59db.firebaseio.com/");
                    // Firebase fb_to_read = ref.child("students");
                    // Firebase fb_put_child = fb_to_read.push();//REMEMBER THIS FOR PUSH METHOD
                    //Firebase fb_put_child = fb_to_read.child(Email_Id);

                    // Creating object
                   /*Student student = new Student();
                    student.setName(Student_name);
                    student.setBranch(text);
                    student.setYear(text1);
                    student.setSection(Section);
                    student.setEmail(Email_Id);
                    student.setContact(Contact);
*/
                    ref.child("students").child(text).setValue(text, text1);
                    Toast.makeText(getBaseContext(), "Successfully Registered ! please login", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(register.this, LoginActivity.class);
                    startActivity(intent);


                    //send data to firebase

                }   //next activity
            }
        });
    }

}

