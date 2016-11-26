package com.martin.calculadorasimples.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.martin.calculadorasimples.entidade.Calculo;

import java.util.ArrayList;

/**
 * Created by 978907 on 29/10/2016.
 */
public class DbConexao extends SQLiteOpenHelper {
    private static final String NOME_BASE = "calculadora.db";
    private static final int VARSAO_BASE = 1;



    public DbConexao(Context context) {
        super(context, NOME_BASE, null, VARSAO_BASE);
    }


    public void inserir(Calculo calculo){
        ContentValues values = new ContentValues();
        values.put("valorum", calculo.getValorUm());
        values.put("valordois", calculo.getValorDois());
        values.put("operador", calculo.getOperador());
        values.put("resposta", calculo.getResposta());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("calculos", null, values);
        db.close();
    }

    public void alterar(Calculo calculo) {

        ContentValues values = new ContentValues();
        values.put("valorum", calculo.getValorUm());
        values.put("valordois", calculo.getValorDois());
        values.put("operador", calculo.getOperador());
        values.put("resposta", calculo.getResposta());
        String whare = "id = ?";

        SQLiteDatabase db = getWritableDatabase();
        int id = db.update("calculos", values, whare,
                new String[]{String.valueOf(calculo.getId())});
        db.close();
    }

    public void excluir(long id) {

        String whare = "id = ?";

        SQLiteDatabase db = getWritableDatabase();
        int ret = db.delete("calculos", whare,
                new String[]{String.valueOf(id)});
        db.close();
    }



    public int getQuantidade(){
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery = "SELECT * FROM calculos";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor.getCount();
    }

    public Calculo getItem(int posicao){
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery = "SELECT * FROM calculos";
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<Calculo> calculoLista = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Calculo calculo= new Calculo();
                calculo.setId(cursor.getLong(0));
                calculo.setValorUm(cursor.getDouble(1));
                calculo.setValorDois(cursor.getDouble(2));
                calculo.setOperador(cursor.getString(3));
                calculo.setResposta(cursor.getDouble(4));
                calculoLista.add(calculo);
            } while (cursor.moveToNext());
            db.close();
        }
        return calculoLista.get(posicao);
    }


   @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CRIA_TABELA_calculo = "CREATE TABLE calculos("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + "valorum Real, "
                + "valordois Real, "
                + "operador text, "
                + "resposta Real )";
        sqLiteDatabase.execSQL(CRIA_TABELA_calculo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}
