package com.martin.calculadorasimples.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.martin.calculadorasimples.entidade.Calculo;

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
        values.put("resposta", calculo.getResposta());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("calculos", null, values);
        db.close();
    }

   @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CRIA_TABELA_calculo = "CREATE TABLE calculos("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + "valorum Real, "
                + "valordois Real, "
                + "resposta Real )";
        sqLiteDatabase.execSQL(CRIA_TABELA_calculo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
