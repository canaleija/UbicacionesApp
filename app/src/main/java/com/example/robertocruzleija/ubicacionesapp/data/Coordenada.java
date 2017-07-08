package com.example.robertocruzleija.ubicacionesapp.data;

/**
 * Created by Roberto Cruz Leija on 08/07/2017.
 */

public class Coordenada {

    private String nombre;
    private double lat;
    private double longi;

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

    @Override
    public String toString() {
         return ""+this.nombre+" Lat: "+this.lat+" Long: "+this.longi;
    }
}
