package com.example.inventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextID;
    private EditText editTextName;
    private EditText editTextQty;

    private String name;
    private int quantity;
    private String ID;

    private dbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new dbHelper(this);

        editTextID = findViewById(R.id.eIDfield);
        editTextName = findViewById(R.id.eProdname);
        editTextQty = findViewById(R.id.eQntyfield);

        Button buttonSave = findViewById(R.id.btnAdd);
        Button buttonRead = findViewById(R.id.btnView);
        Button buttonUpdate = findViewById(R.id.btnUpdate);
        Button buttonDelete = findViewById(R.id.btnDelete);
        Button buttonSearch = findViewById(R.id.btnSearch);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString();
                String qty = editTextQty.getText().toString();
                if (name.isEmpty() || qty.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter required information!", Toast.LENGTH_SHORT).show();
                } else {
                    quantity = Integer.parseInt(qty);
                    try {
                        db.insertData(name, quantity);
                        editTextID.getText().clear();
                        editTextName.getText().clear();
                        editTextQty.getText().clear();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
                String name;
                String qty;
                String id;

                try {
                    Cursor cursor = db.readData();
                    if (cursor != null && cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            id = cursor.getString(0); // get data in column index 0
                            name = cursor.getString(1); // get data in column index 1
                            qty = cursor.getString(2); // get data in column index 2
                            adapter.add("ID :- " + id + "\n" +
                                    "Product Name :- " + name + "\n" +
                                    "Quantity :- " + qty + "\n\n");
                        }
                    } else {

                        adapter.add("No Data");
                    }
                    cursor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Product Stored");
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = editTextName.getText().toString();

                String qty = editTextQty.getText().toString();
                ID = editTextID.getText().toString();

                if (name.isEmpty() || qty.isEmpty() || ID.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Please enter required information!", Toast.LENGTH_SHORT).show();
                } else {
                    quantity = Integer.parseInt(qty);
                    try {
                        db.updateData(ID, name, quantity);
                        editTextID.getText().clear();
                        editTextName.getText().clear();
                        editTextQty.getText().clear();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ID = editTextID.getText().toString();

                if (ID.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Please enter the ID", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        db.deleteData(ID);
                        editTextID.getText().clear();
                        editTextName.getText().clear();
                        editTextQty.getText().clear();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ID = editTextID.getText().toString();

                if (ID.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the ID", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Cursor cursor = db.searchData(ID);
                        if (cursor.moveToFirst()) {

                            editTextName.setText(cursor.getString(1));
                            editTextQty.setText(cursor.getString(2));
                            Toast.makeText(MainActivity.this, "Data successfully searched", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "ID not found", Toast.LENGTH_SHORT).show();

                            editTextQty.setText("ID Not found");
                            editTextName.setText("ID not found");
                        }
                        cursor.close();

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

            }
        });



    }

}