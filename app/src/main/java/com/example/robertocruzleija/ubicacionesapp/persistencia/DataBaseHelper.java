package com.example.robertocruzleija.ubicacionesapp.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.robertocruzleija.ubicacionesapp.R;
import com.example.robertocruzleija.ubicacionesapp.data.Coordenada;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Roberto Cruz Leija on 22/07/2017.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "mapa.db";
    private static final int DATABASE_VERSION = 1;

    // EL MONO NORMAL QUE HACE CRUD
    private Dao<Coordenada,Integer> daoCoordenada = null;
    // EL MONO PODEROSO QUE HACE CRUD PERO TMB CONTROLA LAS EXCEPCIONES
    private RuntimeExceptionDao<Coordenada,Integer> daoCoordenadaPoderoso = null;

    public DataBaseHelper (Context contexto){
        super(contexto,DATABASE_NAME,null,DATABASE_VERSION, R.raw.config_file);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
      // garantizar la creacion de nuestra base de datos
        try {
            TableUtils.createTable(connectionSource,Coordenada.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            // eliminar las tablas
            TableUtils.dropTable(connectionSource,Coordenada.class,true);
            // crear las tablas
            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Coordenada, Integer> getDaoCoordenada() throws SQLException {
        if (this.daoCoordenada == null){

            this.daoCoordenada = getDao(Coordenada.class);
        }
        return daoCoordenada;
    }

    public RuntimeExceptionDao<Coordenada, Integer> getDaoCoordenadaPoderoso() {

        if (this.daoCoordenadaPoderoso == null){

            this.daoCoordenadaPoderoso = getRuntimeExceptionDao(Coordenada.class);
        }

        return daoCoordenadaPoderoso;
    }

    @Override
    public void close() {
        super.close();
        this.daoCoordenada = null;
        this.daoCoordenadaPoderoso = null;
    }
}
