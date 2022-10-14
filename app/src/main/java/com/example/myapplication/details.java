package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class details extends AppCompatActivity {
    private EditText info,add,name,num;
    private Button move,get;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("details");
  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        info=findViewById(R.id.editText);
        add=findViewById(R.id.editTextTextPersonName2);
        get=findViewById(R.id.button2);
        move=findViewById(R.id.button3);
        name=findViewById(R.id.editTextTextPersonName3);
        num=findViewById(R.id.editTextNumber2);
        checkCredentials();
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a=(EditText)findViewById(R.id.editText);
                TextView t=(TextView)findViewById(R.id.textView2);
                TextView t2=(TextView)findViewById(R.id.textView3);
                Button btn =(Button)findViewById(R.id.button2);
                int num1=Integer.parseInt(a.getText().toString());
                float num2=5;
                float num3=2;
                Float max=(num1*num2)-(num2*num3) ;
                Float min=(num1/num2)+num2;
                t.setText(Float.toString(max));
                t2.setText(Float.toString(min));

            }
        });


    }

    private void checkCredentials() {
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit=info.getText().toString();
                String get=add.getText().toString();
                String nam=name.getText().toString();
                String no=num.getText().toString();
                if(nam.isEmpty()){
                    name.setError("INVALID NAME");
                }
                else if(no.isEmpty()||no.length()<10){
                    num.setError("INVALID NUMBER");
                }
                else if(get.isEmpty()){
                    add.setError("INVALID ADDRESS");
                }
                else{
                    Intent intent=new Intent(details.this,Final.class);
                    startActivity(intent);
                    HashMap<String,String>userMap=new HashMap<>();

                    userMap.put("details",edit);
                    userMap.put("address",get);
                    userMap.put("number",no);
                    userMap.put("name",nam);
                    root.push().setValue(userMap);
                }


            }
        });
    }


}