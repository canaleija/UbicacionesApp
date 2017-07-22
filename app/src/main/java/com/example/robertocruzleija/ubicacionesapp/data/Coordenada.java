package com.example.robertocruzleija.ubicacionesapp.data;

import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Roberto Cruz Leija on 08/07/2017.
 */

@DatabaseTable(tableName = "coordenada")
public class Coordenada implements Serializable {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false,index = true)
    private String nombre;
    @DatabaseField
    private double lat;
    @DatabaseField
    private double longi;

    // ORMLITE ME PIDE UN CONSTRUCTOR POR DEFECTO
    public Coordenada(){

    }
    public Coordenada(String nombre, double lat, double longi) {
        this.nombre = nombre;
        this.lat = lat;
        this.longi = longi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
         return ""+this.nombre+" Lat: "+this.lat+" Long: "+this.longi;
    }
}
