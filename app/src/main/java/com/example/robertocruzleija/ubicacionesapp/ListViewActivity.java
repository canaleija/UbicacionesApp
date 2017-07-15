package com.example.robertocruzleija.ubicacionesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.robertocruzleija.ubicacionesapp.adapters.AdaptadorCoordenada;
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
        // llenando la coleccion de coordenadas con lo que tenia el bundle
        for(int x=0; x < extras.size();x++){
            coordenadas.add((Coordenada)extras.getSerializable("coordenada"+x));
        }
        // instanciamos el adaptador nopiñata
        AdaptadorCoordenada adapCoordenada =
                 new AdaptadorCoordenada(this,coordenadas);
        // seteamos el nuevo adaptador al listview
         this.lista.setAdapter(adapCoordenada);
    }
}
