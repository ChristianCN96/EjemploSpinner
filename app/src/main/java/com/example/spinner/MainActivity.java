package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText valor1, valor2;
    private Spinner calcular;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.txt_valor1);
        valor2 = (EditText) findViewById(R.id.txt_valor2);
        calcular = (Spinner) findViewById(R.id.spr_calculo);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        String [] Opciones = {"Suma", "Resta", "Multiplicación", "Divicion"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.
                spinner_item_panda, Opciones);

        calcular.setAdapter(adapter);
    }

    //Metodo de la funcion del boton
    public void Calcular (View view){
        String valor1_String = valor1.getText().toString();
        String valor2_String = valor2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = calcular.getSelectedItem().toString();

        if (seleccion.equals("Suma")){
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv_resultado.setText(resultado);
        }else if (seleccion.equals("Resta")){
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv_resultado.setText(resultado);
        }else if (seleccion.equals("Multiplicación")){
            int multiplicacion = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicacion);
            tv_resultado.setText(resultado);
        }else if (seleccion.equals("Divicion")){
            
            if (valor2_int != 0){
            int division = valor1_int / valor2_int;
            String resultado = String.valueOf(division);
            tv_resultado.setText(resultado);
            }else {

                Toast.makeText(this, "No se puede dividir entre cero",Toast.LENGTH_LONG).show();
            }
        }
    }
}