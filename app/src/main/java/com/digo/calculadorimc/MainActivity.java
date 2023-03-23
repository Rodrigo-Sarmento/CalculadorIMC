package com.digo.calculadorimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView teResultado;
    private TextView teSituacao;
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        teResultado = findViewById(R.id.teResultado);
        teSituacao = findViewById(R.id.teSituacao);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCalcularOnClick();
            }
        });
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLimparOnClick();
            }
        });

    }

    private void btCalcularOnClick(){
        if (etPeso.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo do Peso precisa ser preenchido",
                    Toast.LENGTH_LONG).show();
            etPeso.requestFocus();
            return;
        }
        if (etAltura.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"CAMPO PESO DEVE SER PREENCHIDO" ,
                    Toast.LENGTH_LONG).show();
            etAltura.requestFocus();
            return;
        }
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());
        double imc = peso / Math.pow(altura,2);
        teResultado.setText(new DecimalFormat("0.00").format(imc));
        if(imc >= 18.5 && imc <= 24.9){
            teSituacao.setText("Parabéns-você está em seu peso normal!");
        }else if(imc > 24.9 && imc <= 29.9){
            teSituacao.setText("Você está acima de seu peso(sobrepeso).");
        }else if(imc > 29.9 && imc <= 34.9){
            teSituacao.setText("Obesidade grau 1.");
        }else if(imc > 34.9 && imc <= 39.9){
            teSituacao.setText("Obesidade grau 2(severa).");
        }else if(imc > 39.9){
            teSituacao.setText("Obesidade grau 3(mórbida).");
        }else if(imc < 18.5){
            teSituacao.setText("Você está abaixo de seu peso");
        }
    }

    private void btLimparOnClick(){
        etPeso.setText("");
        etAltura.setText("");
        teResultado.setText("IMC");
        teSituacao.setText("Situação");
    }
}