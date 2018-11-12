package com.example.norman_lee.displayingdatanew;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class DataEntryActivity extends AppCompatActivity {

    ImageView imageViewSelected;
    CharaDbHelper charaDbHelper;
    EditText editTextName;
    EditText editTextDescription;
    Bitmap bitmapSelected = null;
    SQLiteDatabase db;
    int REQUEST_CODE_IMAGE = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        //TODO 8.4 Get a reference to the CharaDbHelper

        //TODO 8.5 Get references to the widgets

        //TODO 8.6 when the selectImage button is clicked, set up an Implicit Intent to the gallery

        //TODO 8.8 when the OK button is clicked, add the data to the db


    }

    //TODO 8.7 Complete OnActivityResult so that the selected image is displayed in the imageView
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
