package com.example.norman_lee.displayingdatanew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

public class RecylerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharaAdapter charaAdapter;
    CharaDbHelper charaDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);

        //TODO 9.7 The standard code to fill the recyclerview with data

        //TODO 9.8 Put in code to allow each recyclerview item to be deleted when swiped

        //TODO 9.9 attach the recyclerView to helper


    }
}
