package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Innum1;
    private EditText Innum2;
    private TextView tVResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Innum1 = (EditText)findViewById(R.id.Innum1);
        Innum2 = (EditText)findViewById(R.id.Innum2);
        tVResult = (TextView) findViewById(R.id.tVResult);
    }

    public void btnPlus(View view) {
        int n1 = Integer.parseInt(Innum1.getText().toString());
        int n2 = Integer.parseInt(Innum2.getText().toString());
        int sum = n1 + n2;
        tVResult.setText(String.valueOf(sum));
    }

    public void btnMinus(View view) {
        int n1 = Integer.parseInt(Innum1.getText().toString());
        int n2 = Integer.parseInt(Innum2.getText().toString());
        int sub = n1 - n2;
        tVResult.setText(String.valueOf(sub));
    }

    public void btnTimes(View view) {
        int n1 = Integer.parseInt(Innum1.getText().toString());
        int n2 = Integer.parseInt(Innum2.getText().toString());
        int prod = n1 * n2;
        tVResult.setText(String.valueOf(prod));
    }

    public void btnDiv(View view) {

        try {
            int n1 = Integer.parseInt(Innum1.getText().toString());
            int n2 = Integer.parseInt(Innum2.getText().toString());
            int quo = n1 / n2;
            tVResult.setText(String.valueOf(quo));
        }catch(ArithmeticException e){
            tVResult.setText("Can't be divided by 0");
        }
    }

    public void btnClr(View view) {
        Innum1.setText("");
        Innum2.setText("");
        tVResult.setText("");

    }
}