package com.example.andreavalenziano.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AndreaValenziano on 17/02/17.
 */
public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameET;
    String name="",id="";
    String newName="";
    Button submitBtn;
    final int TEXT_MAX_LENGTH=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent i=getIntent();
        name=i.getStringExtra(ContactActivity.USER_NAME);
        id=i.getStringExtra(ContactActivity.ID);
        submitBtn=(Button)findViewById(R.id.submit);



        setTitle(name);
        nameET=(EditText)findViewById(R.id.set_name);
        nameET.setHint(name);
        nameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<TEXT_MAX_LENGTH){
                    setTitle(s);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                newName=s.toString();

            }
        });

        submitBtn.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {



        Intent intent=new Intent();
        intent.putExtra(ContactActivity.USER_NAME,newName);
        intent.putExtra(ContactActivity.ID,id);
       setResult(Activity.RESULT_OK,intent);
        finish();

    }
}
