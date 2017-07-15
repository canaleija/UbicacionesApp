package com.example.robertocruzleija.ubicacionesapp.listeners;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.robertocruzleija.ubicacionesapp.ListViewActivity;
import com.example.robertocruzleija.ubicacionesapp.MainActivity;
import com.example.robertocruzleija.ubicacionesapp.R;
import com.example.robertocruzleija.ubicacionesapp.data.Coordenada;

import java.util.ArrayList;

/**
 * Created by Roberto Cruz Leija on 08/07/2017.
 */

public class ListenerBotones implements View.OnClickListener {

    MainActivity contexto;
     // constructor por defecto
    public ListenerBotones(MainActivity contexto) {
       this.contexto = contexto;
    }

    @Override
    public void onClick(View v) {
    // verificar el boton
      Button btn = (Button)v;
        switch (btn.getId()){
            case R.id.btnAgregarCoordenada:{
                // creamos la coordenada
                // jalando los valores de los edittext
                String nombre = contexto.getEdtNombre().getText().toString();
                double lati = Double.parseDouble( contexto.getEdtLati().getText().toString());
                double longi = Double.parseDouble(contexto.getEdtLongi().getText().toString());
                // instanciar un nueva coordenada
                Coordenada co1 = new Coordenada(nombre,lati,longi);
                // agregamos la coordenada a la coleccion
                contexto.getCoordenadas().add(co1);
                break;
            }
            case R.id.btnVerCoordenadas:{
                Intent intento = new Intent(contexto, ListViewActivity.class);
                // mandar las coordenadas
                //genero una referencia de la coleccion de coordenadas
                ArrayList<Coordenada> aux = contexto.getCoordenadas();
                Bundle extras = new Bundle();
                // agregar todas las coordenadas de la coleccion +
                // al objeto bundle llamado extras
                // recorrer todas las coordenadas
                for (int x=0; x < aux.size();x++){
                    extras.putSerializable("coordenada"+x,aux.get(x));
                }
                // agregamos el bundle como extra
                intento.putExtras(extras);
                // se ejecuta la actividad
                contexto.startActivity(intento);
                break;
            }

        }
    }
}
