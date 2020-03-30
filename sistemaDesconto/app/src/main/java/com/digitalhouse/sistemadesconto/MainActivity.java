package com.digitalhouse.sistemadesconto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText valorProduto;
    EditText valorPorcentagem;
    Activity activity = this;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorProduto = findViewById(R.id.input_valorProduto);
        valorPorcentagem = findViewById(R.id.input_porcentagem);
        button = findViewById(R.id.button);


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String verifacaoProduto = valorProduto.getText().toString();
                String verificaoPorcentagem = valorPorcentagem.getText().toString();
                if(verifacaoProduto.isEmpty() || verificaoPorcentagem.isEmpty()){
                    Toast.makeText(activity, "por favor preencha os valores corretos", Toast.LENGTH_LONG).show();
                }else {
                    int porcentagem = Integer.parseInt(valorPorcentagem.getText().toString());
                    int produto = Integer.parseInt(valorProduto.getText().toString());
                    calcularPorcentagem(porcentagem, produto);
                }

            }
        });


    }

    public void calcularPorcentagem(int valorPorcentagem, int valorProduto ){

        int resultado = valorProduto - (valorPorcentagem * valorProduto / 100);
        String retornoDeValor = String.valueOf(resultado);
        Toast.makeText(activity, retornoDeValor,Toast.LENGTH_LONG).show();
    }

    }

