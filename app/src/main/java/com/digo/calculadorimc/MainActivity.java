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
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        teResultado = findViewById(R.id.teResultado);
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
    }

    private void btLimparOnClick(){
        etPeso.setText("");
        etAltura.setText("");
        teResultado.setText("0.0");
    }
}