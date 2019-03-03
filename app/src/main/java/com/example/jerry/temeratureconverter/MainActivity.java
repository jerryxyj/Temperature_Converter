package com.example.jerry.temeratureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;
    private TextView history;
    private double value;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText) findViewById(R.id.Input);
        output=(TextView) findViewById(R.id.output);
        history=(TextView) findViewById(R.id.history);
        //Enabling scrolling on Textview(history)
        history.setMovementMethod(new ScrollingMovementMethod());




    }
    public void convert(View v){

        RadioButton fc=(RadioButton) findViewById(R.id.FtoC);
        RadioButton cf=(RadioButton) findViewById(R.id.CtoF);
        value=Double.parseDouble(String.valueOf(input.getText()));
        CharSequence label;


        if(fc.isChecked()){


            double cal=(value-32)*5/9;
            String show=String .format("%.1f",cal);
            output.setText(show);
            label="F to C: "+value+" → "+show;

        }
        else{

            double cal=value*9/5+32;
            String show=String .format("%.1f",cal);
            output.setText(show);
            label="C to F: "+value+" → "+show;
        }
        String mark=history.getText().toString();
        history.setText(label.toString()+'\n'+mark);


    }
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("output",output.getText().toString());
        outState.putString("HISTORY", history.getText().toString());
        outState.putDouble("VALUE", value);


        // Call super last
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Call super first
        super.onRestoreInstanceState(savedInstanceState);
        output.setText(savedInstanceState.getString("output"));
        history.setText(savedInstanceState.getString("HISTORY"));
        value = savedInstanceState.getDouble("VALUE");
    }

}
