package com.martin.calculadorasimples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.martin.calculadorasimples.adaptador.AdapterListaResultados;
import com.martin.calculadorasimples.entidade.Calculo;
import com.martin.calculadorasimples.persistencia.DbConexao;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton adicaoButton, subtracaoButton, multiplicacaoButton, divisaoButton;
    Button limpaButton;
    EditText valorUmEditText, valorDoisEditText;
    TextView respostaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        adicaoButton = (ImageButton) findViewById(R.id.adicaoImageButton);
        subtracaoButton = (ImageButton) findViewById(R.id.subtracaoImageButton);
        multiplicacaoButton = (ImageButton) findViewById(R.id.multiplicacaoImageButton);
        divisaoButton = (ImageButton) findViewById(R.id.divisaoIageButton);
        limpaButton = (Button) findViewById(R.id.limpaButton);

        adicaoButton.setOnClickListener(this);
        subtracaoButton.setOnClickListener(this);
        multiplicacaoButton.setOnClickListener(this);
        divisaoButton.setOnClickListener(this);
        limpaButton.setOnClickListener(this);

        valorUmEditText = (EditText) findViewById(R.id.valorUmEditText);
        valorDoisEditText = (EditText) findViewById(R.id.valorDoisEditText);
        respostaTextView = (TextView) findViewById(R.id.respostaTextView);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new AdapterListaResultados(this));

    }

    @Override
    public void onClick(View view) {
        Log.d("MEUAPP", String.valueOf(view.getId()));

        double valorUm = 0;
        double valorDois = 0;
        double resultado = 0;

        try {
            valorUm = Float.parseFloat(valorUmEditText.getText().toString());
            valorDois = Float.parseFloat(valorDoisEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this,"Valor inválido",Toast.LENGTH_SHORT).show();
        }

        switch (view.getId()){
            case R.id.adicaoImageButton:
                resultado = valorUm + valorDois;
                break;
            case R.id.subtracaoImageButton:
                resultado = valorUm - valorDois;
                break;
            case R.id.multiplicacaoImageButton:
                resultado = valorUm * valorDois;
                break;
            case R.id.divisaoIageButton:
                resultado = valorUm / valorDois;
                break;
            case R.id.limpaButton:
                respostaTextView.setText("");
                valorUmEditText.setText("");
                valorDoisEditText.setText("");
                break;
        }
        respostaTextView.setText(String.valueOf(resultado));

        Calculo calculo = new Calculo(valorUm, valorDois, resultado);
        DbConexao dbConexao = new DbConexao(this);
        dbConexao.inserir(calculo);

    }
}








