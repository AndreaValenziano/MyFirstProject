package com.example.andreavalenziano.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AndreaValenziano on 10/02/17.
 */

public class LoginActivity extends Activity implements View.OnClickListener {
    EditText usernameET;
    EditText passwordET;
    Button loginBtn;
    public static final String EMAIL_KEY="email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = (EditText) findViewById(R.id.account);
        passwordET = (EditText) findViewById(R.id.password);
        loginBtn=(Button) findViewById(R.id.login) ;

        loginBtn.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        if (doLogin(username, password)) {
            Toast.makeText(LoginActivity.this, R.string.login_success, Toast.LENGTH_LONG).show();
            Intent intent=new Intent(LoginActivity.this, ContactActivity.class);
            intent.putExtra(EMAIL_KEY,username);
            startActivity(intent);
            
        }


    }

    private boolean doLogin(String username, String password) {
        //do something
        return true;
    }
}
