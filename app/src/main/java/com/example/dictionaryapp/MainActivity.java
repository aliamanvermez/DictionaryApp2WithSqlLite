package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {



    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<Kelimeler>kelimelerArrayList;
    private Adapter adapter;
    private Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        recyclerView =findViewById(R.id.recyclerView);

        toolbar.setTitle("Dictionary App");
        setSupportActionBar(toolbar);

        vt = new Veritabani(this);

        veritabaniKopyala();


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        kelimelerArrayList = new ArrayList<>();

        kelimelerArrayList = new KelimelerDao().tumKelimeler(vt);

        adapter= new Adapter(this,kelimelerArrayList);

        recyclerView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        Log.e("Gonderilen metin",query);
        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf gidrdikçe",newText);
        aramaYap(newText);
        return false;
    }

    public void veritabaniKopyala (){

        DatabaseCopyHelper databaseCopyHelper = new DatabaseCopyHelper(this);
        try {
                databaseCopyHelper.createDataBase();
        }catch (IOException e) {
            e.printStackTrace();
        }

        databaseCopyHelper.openDataBase();

    }

    public void aramaYap(String aramaKelime){
        kelimelerArrayList = new KelimelerDao().kelimeAra(vt,aramaKelime);

        adapter= new Adapter(this,kelimelerArrayList);

        recyclerView.setAdapter(adapter);
    }

}

























