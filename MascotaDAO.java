package com.example.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mascotas.model.Mascota;

import java.util.ArrayList;

public class MascotaDAO {
    private BaseDatos dbHelper;

    public MascotaDAO(Context context) {
        dbHelper = new BaseDatos(context);
    }

    public void agregarMascota(Mascota mascota) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BaseDatos.COLUMN_ID, mascota.getId());
        values.put(BaseDatos.COLUMN_NOMBRE, mascota.getNombre());
        values.put(BaseDatos.COLUMN_FOTO, mascota.getFoto());
        values.put(BaseDatos.COLUMN_RATING, mascota.getRating());

        db.insertWithOnConflict(BaseDatos.TABLE_MASCOTA, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        Cursor cursor = db.rawQuery("SELECT id FROM " + BaseDatos.TABLE_MASCOTA + " ORDER BY id DESC", null);
        if (cursor.getCount() > 5) {
            cursor.moveToPosition(4);
            int limite = cursor.getInt(0);
            db.delete(BaseDatos.TABLE_MASCOTA, "id < ?", new String[]{String.valueOf(limite)});
        }
        cursor.close();
        db.close();
    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(BaseDatos.TABLE_MASCOTA, null, null, null, null, null, "id DESC");

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(BaseDatos.COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow(BaseDatos.COLUMN_NOMBRE));
                int foto = cursor.getInt(cursor.getColumnIndexOrThrow(BaseDatos.COLUMN_FOTO));
                int rating = cursor.getInt(cursor.getColumnIndexOrThrow(BaseDatos.COLUMN_RATING));
                mascotas.add(new Mascota(id, nombre, foto, rating));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return mascotas;
    }
}
