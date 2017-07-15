package com.example.robertocruzleija.ubicacionesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.robertocruzleija.ubicacionesapp.data.Coordenada;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        // se referencia el listview
        this.lista =(ListView) findViewById(R.id.listViewCoordenadas);
        // pedimos el bundle de los extras al intento
        Bundle extras = getIntent().getExtras();
        // desmenusamos el bundle
        Coordenada coor = (Coordenada) extras.getSerializable("coordenada0");
        ArrayList<Coordenada> coordenadas = new ArrayList<>();

        String []items = new String[5];
        for(int x=0; x < extras.size();x++){
            coordenadas.add((Coordenada)extras.getSerializable("coordenada"+x));
            items[x] = coordenadas.get(x).toString();
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
         this.lista.setAdapter(itemsAdapter);
    }
}
