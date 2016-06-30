package com.joseanguiano.newpetagram;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " INTEGER, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " DESC LIMIT 0,5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public int verificarExisteMascotaBD(Mascota mascota){

        int mascotaExiste = 0;

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM "
                + ConstantesBaseDatos.TABLE_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE +
                " = '" + mascota.getNombre() + "'";

        Cursor registrosVerificar = db.rawQuery(query, null);

        if (registrosVerificar.moveToNext()){
            mascotaExiste = 1;
        }

        db.close();

        return mascotaExiste;
    }

    public void insertarLikeMascota (Mascota mascota){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " SET " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " = " +
                "(" + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES +
                " + 1) WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE +
                " = '" + mascota.getNombre() + "'";

        db.execSQL(query);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE +
                " = '" + mascota.getNombre() + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

}
