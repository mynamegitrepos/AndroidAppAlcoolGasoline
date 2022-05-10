package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText e_p_alcool, e_p_gasolina;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_p_alcool = findViewById(R.id.e_p_alcool);
        e_p_gasolina = findViewById(R.id.e_p_gasolina);
        text_resultado = findViewById(R.id.text_resultado);
    }

    public void calcularPreco(View view){
        String precoAlcool = e_p_alcool.getText().toString();
        String precoGasolina = e_p_gasolina.getText().toString();

        Boolean resultado = validarCampos(precoAlcool, precoGasolina);
        if (resultado){
         Double valorAlcool = Double.parseDouble(precoAlcool);
         Double valorGasolina = Double.parseDouble(precoGasolina);
         Double div = valorAlcool / valorGasolina;

         if (div >= 0.7){

             text_resultado.setText("Utilizar Gasolina");
         }else{
             text_resultado.setText("Utilizar alcool");
         }
        }else{
            text_resultado.setText("Preencha os preços primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")){
          camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
