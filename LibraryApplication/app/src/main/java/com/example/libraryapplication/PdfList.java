package com.example.libraryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PdfList extends AppCompatActivity {

//    private static File outputFile;
//    ListView pdflistview;
    DrawerLayout drawerLayout;
    Window window;
    RecyclerView rc;
    PDFAdapter pdfAdapter;
    List<ListValue> listed = new ArrayList<>();
    ImageView dlButton;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_list);
        drawerLayout = findViewById(R.id.drawer_layout);
        dlButton = (ImageView) findViewById(R.id.dl_button);
        getList();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Lesson 3", "Lesson 4",
                "Lesson 6 & 7 Dialogs", "Lesson 6 & 7 Lists","Lesson 6 & 7 Menus","Lesson 6 & 7 Notification and Toast",
                "Lesson 8 & 10 Data Driven Model", "Lesson 9 Location and Maps", "Lesson 10 Working with DB", "Lesson 11", "Lesson 12"));

//        ArrayList<String> lister = new ArrayList<>(Arrays.asList("Download", "Download", "Download", "Download", "Download", "Download", "Download", "Download", "Download", "Download"));

        rc = findViewById(R.id.recyler);
        rc.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(RecyclerView.VERTICAL);
        rc.setLayoutManager(lm);


        pdfAdapter = new PDFAdapter(this, listed);
        rc.setAdapter(pdfAdapter);


        rc.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rc, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String item = list.get(position);
                        Intent intent = new Intent(getApplicationContext(), PDFOpener.class);
                        intent.putExtra("pdfFileName", item);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onDownloadClick(View view, int position) {

                    }

                })
        );
        ImageView s = findViewById(R.id.dl_button);
//        rc.addOnItemTouchListener(new RecyclerItemClickListener(context, s, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//
//            }
//
//            @Override
//            public void onDownloadClick(View view, int position) {
//
//            }
//        }));


        if (Build.VERSION.SDK_INT >= 21) {
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.color));
        }

    }
    private void getList() {

        //listed.add(new ListValue("Lesson3", "Download"));

        listed.add(new ListValue("Lesson 3"));
        listed.add(new ListValue("Lesson 4"));
        listed.add(new ListValue("Lesson 6 & 7 Dialogs"));
        listed.add(new ListValue("Lesson 6 & 7 Lists"));
        listed.add(new ListValue("Lesson 6 & 7 Menus"));
        listed.add(new ListValue("Lesson 6 & 7 Notification and Toast"));
        listed.add(new ListValue("Lesson 8 & 10 Data Driven Model"));
        listed.add(new ListValue("Lesson 9 Location and Maps"));
        listed.add(new ListValue("Lesson 10 Working with DB"));
        listed.add(new ListValue("Lesson 11"));
        listed.add(new ListValue("Lesson 12"));
    }

    public void ClickReturn(View view) {
        Intent intent  = new Intent(this,ThirdyrActivity.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        Intent intent  = new Intent(this,ThirdyrActivity.class);
        startActivity(intent);
    }

    public void Clicksearch(View view) {
        Intent intent  = new Intent(this,Searsh.class);
        startActivity(intent);
    }
//    private void CopyReadAssets(int position)
//    {
//        AssetManager assetManager = getAssets();
//
//        InputStream in = null;
//        OutputStream out = null;
//        File file = new File(getFilesDir(), ".pdf");
//        try
//        {
//            in = assetManager.open("abc.pdf");
//            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);
//
//            copyFile(in, out);
//            in.close();
//            in = null;
//            out.flush();
//            out.close();
//            out = null;
//        } catch (Exception e)
//        {
//            Log.e("tag", e.getMessage());
//        }
//
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(
//                Uri.parse("file://" + getFilesDir() + ".pdf"),
//                "application/pdf");
//
//        startActivity(intent);
//    }

//    private void copyFile(InputStream in, OutputStream out) throws IOException
//    {
//        byte[] buffer = new byte[1024];
//        int read;
//        while ((read = in.read(buffer)) != -1)
//        {
//            out.write(buffer, 0, read);
//        }
    }







