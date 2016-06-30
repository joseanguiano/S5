package com.joseanguiano.newpetagram;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);

        return db.obtenerMascotasFavoritas();
    }

    public void insertarMascota(Mascota mascota){

        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, LIKE);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, mascota.getFoto());

        db.insertarMascota(contentValues);
    }

    public int verificarMascota(Mascota mascota){
        int verificarMascota;
        BaseDatos db = new BaseDatos(context);
        verificarMascota = db.verificarExisteMascotaBD(mascota);

        return verificarMascota;
    }

    public void insertarLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.obtenerMascotasFavoritas();
        db.insertarLikeMascota(mascota);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.obtenerMascotasFavoritas();
        return db.obtenerLikesMascota(mascota);
    }

}
