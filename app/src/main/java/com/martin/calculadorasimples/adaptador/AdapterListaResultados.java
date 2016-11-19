package com.martin.calculadorasimples.adaptador;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.martin.calculadorasimples.R;
import com.martin.calculadorasimples.entidade.Calculo;
import com.martin.calculadorasimples.persistencia.DbConexao;

/**
 * Created by 978907 on 19/11/2016.
 */
public class AdapterListaResultados extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterListaResultados(Context context){
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
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
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_listview, null);
        }

        TextView valorUmTextView = (TextView) view.findViewById(R.id.valorUmTextView);
        TextView valorDoisTextView = (TextView) view.findViewById(R.id.valorDoisTextView);
        TextView operadorTextView = (TextView) view.findViewById(R.id.operadorTextView);
        TextView respostaTextView = (TextView) view.findViewById(R.id.RespostaTextView);

        Calculo calculo = (Calculo) getItem(i);
        Log.d("MEUAPP","Posição: "+ i);

        valorUmTextView.setText(String.valueOf(calculo.getValorUm()));
        valorDoisTextView.setText(String.valueOf(calculo.getValorDois()));
        operadorTextView.setText("Não registrado!!!!");
        respostaTextView.setText(String.valueOf(calculo.getResposta()));

        return view;
    }
}
