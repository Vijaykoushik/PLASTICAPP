package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void max(View V){
        EditText a=(EditText)findViewById(R.id.editText);
        TextView t=(TextView)findViewById(R.id.textView2);
        TextView t2=(TextView)findViewById(R.id.textView3);
        Button btn =(Button)findViewById(R.id.button2);
        int num1=Integer.parseInt(a.getText().toString());
        float num2=5;
        Float max=(num1*num2);
        Float min=(num1/num2);
        t.setText(Float.toString(max));
        t2.setText(Float.toString(min));





    }
}