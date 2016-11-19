package com.martin.calculadorasimples.adaptador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.martin.calculadorasimples.persistencia.DbConexao;

/**
 * Created by 978907 on 19/11/2016.
 */
public class AdapterListaResultados extends BaseAdapter {
    private Context context;

    public AdapterListaResultados(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return new DbConexao(context).getQuantidade();
    }

    @Override
    public Object getItem(int i) {
        return new DbConexao(context).getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return new DbConexao(context).getItem(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
