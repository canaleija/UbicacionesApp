package com.example.robertocruzleija.ubicacionesapp.listeners;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.example.robertocruzleija.ubicacionesapp.ListViewActivity;
import com.example.robertocruzleija.ubicacionesapp.R;
import com.example.robertocruzleija.ubicacionesapp.data.Coordenada;
import com.example.robertocruzleija.ubicacionesapp.persistencia.DataBaseHelper;

/**
 * Created by Roberto Cruz Leija on 29/07/2017.
 */

public class ControladorBotonesItem implements View.OnClickListener {

    ArrayAdapter<Coordenada> contexto;
    DataBaseHelper helper;
    Coordenada coordenada;

    public ControladorBotonesItem(ArrayAdapter<Coordenada> contexto, DataBaseHelper helper, Coordenada coordenada) {
        this.contexto = contexto;
        this.helper = helper;
        this.coordenada = coordenada;
    }

    @Override
    public void onClick(View v) {
        ImageButton btn = (ImageButton) v;

        switch (btn.getId()){
            case R.id.imageButtonEliminar: {
                // Eliminamos el item
                this.helper.getDaoCoordenadaPoderoso().delete(coordenada);
                this.contexto.remove(coordenada);
            }
            case R.id.imageButtonEditar: {
                // cierro la conexion
                this.helper.close();
                // ejecuto una actividad y le mando la coordenada
                // y dentro de esa actividad me conecto la base de datos nuevamente y aactualizo la cooordenada


            }
            case R.id.imageButtonVer: {
                // cierro la conexion
                this.helper.close();
                // ejecutamos la actividad del mapa y le mandomos la coordenada


            }


        }
    }
}
