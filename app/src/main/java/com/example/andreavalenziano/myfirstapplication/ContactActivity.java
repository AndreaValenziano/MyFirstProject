package com.example.andreavalenziano.myfirstapplication;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by AndreaValenziano on 10/02/17.
 */

public class ContactActivity extends Activity implements View.OnClickListener {
    Button goBtn, callBtn, sendEmailBtn;
    TextView name, date, cel, email, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        goBtn = (Button) findViewById(R.id.go_btn);
        callBtn = (Button) findViewById(R.id.call_btn);
        sendEmailBtn=(Button) findViewById(R.id.send_email_btn);

        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.date);
        cel = (TextView) findViewById(R.id.tel);
        email = (TextView) findViewById(R.id.email);
        pos = (TextView) findViewById(R.id.pos);

        goBtn.setOnClickListener(this);
        callBtn.setOnClickListener(this);
        sendEmailBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_btn) {
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri=Uri.parse("geo:0,0?q="+pos.getText().toString());
            intent.setData(uri);
            startActivity(intent);
        } else if (v.getId() == R.id.call_btn) {
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri=Uri.parse("tel:"+cel.getText().toString());
            intent.setData(uri);
            startActivity(intent);

        }else if(v.getId()== R.id.send_email_btn){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL,email.getText().toString());
            startActivity(Intent.createChooser(intent, "@string/send_email"));


        }

    }
}
