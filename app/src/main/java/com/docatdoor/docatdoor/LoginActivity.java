package com.docatdoor.docatdoor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;
import static android.content.ContentValues.TAG;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity
{
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public Button b1,b2;
    @Override
    public void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1=(Button)findViewById(R.id.ButtonLogin);
        b2=(Button)findViewById(R.id.ButtonSignup);
        b2.setOnClickListener(new View
                .OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(LoginActivity.this,register.class);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(new View
                .OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user != null) {
                            // User is signed in
                            Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                        } else {
                            // User is signed out
                            Log.d(TAG, "onAuthStateChanged:signed_out");
                        }
                        // ...
                    }
                };
                Intent i=new Intent(LoginActivity.this,AfterLogin.class);
                startActivity(i);
                finish();
            }
        });

    }



}

