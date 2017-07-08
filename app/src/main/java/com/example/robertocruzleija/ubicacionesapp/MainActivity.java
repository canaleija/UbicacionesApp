package com.example.robertocruzleija.ubicacionesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.robertocruzleija.ubicacionesapp.data.Coordenada;
import com.example.robertocruzleija.ubicacionesapp.listeners.ListenerBotones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // GENERAR LOS ATRIBUTOS
    private Button btnAgregar,btnVerCoordenadas;
    private EditText edtNombre,edtLati, edtLongi;
    private ArrayList<Coordenada> coordenadas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // referenciar los views
        refComponentes();
        this.coordenadas = new ArrayList<Coordenada>();
    }

    private void refComponentes() {
        // referencia los diferentes views
        this.edtNombre = (EditText) findViewById(R.id.editTextLugar);
        this.edtLati = (EditText) findViewById(R.id.editTextLatitud);
        this.edtLongi = (EditText) findViewById(R.id.editTextLongitud);
        this.btnVerCoordenadas = (Button) findViewById(R.id.btnVerCoordenadas);
        this.btnAgregar = (Button) findViewById(R.id.btnAgregarCoordenada);

        ListenerBotones lis = new ListenerBotones(this);
        this.btnAgregar.setOnClickListener(lis);
        this.btnVerCoordenadas.setOnClickListener(lis);
    }



    public EditText getEdtNombre() {
        return edtNombre;
    }

    public void setEdtNombre(EditText edtNombre) {
        this.edtNombre = edtNombre;
    }

    public EditText getEdtLati() {
        return edtLati;
    }

    public void setEdtLati(EditText edtLati) {
        this.edtLati = edtLati;
    }

    public EditText getEdtLongi() {
        return edtLongi;
    }

    public void setEdtLongi(EditText edtLongi) {
        this.edtLongi = edtLongi;
    }

    public ArrayList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

}
