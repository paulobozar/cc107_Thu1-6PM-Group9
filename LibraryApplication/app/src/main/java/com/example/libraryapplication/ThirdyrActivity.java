package com.example.libraryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class ThirdyrActivity extends AppCompatActivity {
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdyr);

        if(Build.VERSION.SDK_INT>=21){
            window =this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.color));
        }
    }
    public void Clickcc107(View view) {
        Intent intent  = new Intent(this,PdfList.class);
        startActivity(intent);
    }
    public void CReturn(View view) {
        Intent intent  = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        Intent intent  = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

}