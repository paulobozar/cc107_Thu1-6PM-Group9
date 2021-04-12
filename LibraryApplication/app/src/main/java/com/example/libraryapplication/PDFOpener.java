package com.example.libraryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PDFOpener extends AppCompatActivity implements OnPageChangeListener {
    Window window;
    PDFView mypdfviewer;

    Integer pageNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_opener);
        mypdfviewer=(PDFView)findViewById(R.id.pdfviewer);
        if(Build.VERSION.SDK_INT>=21){
            window =this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.color));
        }


        String getitem=getIntent().getStringExtra("pdfFileName");

            if (getitem.equals("Lesson 3")) {
                mypdfviewer.fromAsset("CC107/Lesson3.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();

            }
            if (getitem.equals("Lesson 4")) {
                mypdfviewer.fromAsset("CC107/Lesson4.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(110)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 6 & 7 Dialogs")) {
                mypdfviewer.fromAsset("CC107/Lesson 6&7 Dialogs.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 6 & 7 Lists")) {
                mypdfviewer.fromAsset("CC107/Lesson 6&7 Lists.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 6 & 7 Menus")) {
                mypdfviewer.fromAsset("CC107/Lesson 6&7 Menus.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 6 & 7 Notification and Toast")) {
                mypdfviewer.fromAsset("CC107/Lesson 6&7 Notification and Toast.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 8 & 10 Data Driven Model")) {
                mypdfviewer.fromAsset("CC107/Lesson 8 & 10 Data Driven Model.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(110)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 9 Location and Maps")) {
                mypdfviewer.fromAsset("CC107/Lesson 9- Location and Maps.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 10 Working with DB")) {
                mypdfviewer.fromAsset("CC107/Lesson 10 _Working with DB.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 11")) {
                mypdfviewer.fromAsset("CC107/Lesson11.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }
            if (getitem.equals("Lesson 12")) {
                mypdfviewer.fromAsset("CC107/Lesson12.pdf")
                        .defaultPage(pageNumber)
                        .enableSwipe(true)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .spacing(10)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .load();
            }


        if(Build.VERSION.SDK_INT>=21){
            window =this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.color));
        }

    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", mypdfviewer, page + 1, pageCount));

    }
    public void CReturn(View view) {
        Intent intent  = new Intent(this,PdfList.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed() {
        Intent intent  = new Intent(this,PdfList.class);
        startActivity(intent);
    }
}