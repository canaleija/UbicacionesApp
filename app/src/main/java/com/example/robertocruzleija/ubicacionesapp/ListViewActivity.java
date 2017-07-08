package com.example.robertocruzleija.ubicacionesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        this.lista =(ListView) findViewById(R.id.listViewCoordenadas);

        String []items = new String[]{"pedro","pablo","eran","hermanos"};

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
         this.lista.setAdapter(itemsAdapter);
    }
}
