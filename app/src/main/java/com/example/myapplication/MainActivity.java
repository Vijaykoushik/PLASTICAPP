package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText mail,number;
    private Button go;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail=findViewById(R.id.editTextTextPersonName);
        number=findViewById(R.id.editTextNumber);
        go=findViewById(R.id.button);
        checkCredentials();



        }

    private void checkCredentials() {


            go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String edit=mail.getText().toString();
                    String a=number.getText().toString();
                    if(edit.isEmpty()|| !edit.contains("@")){
                        mail.setError("INVALID EMAIL");
                    }
                    else if(a.isEmpty()|| a.length()<7){
                        number.setError("INVALID PASSWORD");
                    }
                    else {
                        Intent intent=new Intent(MainActivity.this,details.class);
                        startActivity(intent);

                        HashMap<String,String>userMap=new HashMap<>();

                        userMap.put("mail",edit);
                        userMap.put("number",a);
                        root.push().setValue(userMap);
                    }



                }


            });
        }



    }




