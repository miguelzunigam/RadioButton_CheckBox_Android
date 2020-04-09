package com.example.radiobutton_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public RadioButton radioButtonPrimaria, radioButtonSecundaria,
            radioButtonPreparatoria, radioButtonUniversidad;
    public CheckBox checkBoxTerror, checkBoxAccion, checkBoxComedias, checkBoxRomanticas;
    public ImageButton imageButtonVerificar;
    public RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonPrimaria = (RadioButton) findViewById(R.id.radioButtonPrimaria);
        radioButtonSecundaria = (RadioButton) findViewById(R.id.radioButtonSecundaria);
        radioButtonPreparatoria = (RadioButton) findViewById(R.id.radioButtonPreparatoria);
        radioButtonUniversidad = (RadioButton) findViewById(R.id.radioButtonUniversidad);

        checkBoxAccion = (CheckBox) findViewById(R.id.checkBoxAccion);
        checkBoxComedias = (CheckBox) findViewById(R.id.checkBoxComedias);
        checkBoxRomanticas = (CheckBox) findViewById(R.id.checkBoxRomanticas);
        checkBoxTerror = (CheckBox) findViewById(R.id.checkBoxTerror);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroupEscuela);

        imageButtonVerificar = (ImageButton) findViewById(R.id.imageButtonVerificar);

        imageButtonVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje= verificarPeliculas();
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();

                if(radioGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(MainActivity.this,"Seleciona una opción",Toast.LENGTH_SHORT).show();
                }else{
                    int opcion=radioGroup.getCheckedRadioButtonId();
                    switch (opcion){
                        case R.id.radioButtonPrimaria:
                            Toast.makeText(MainActivity.this,"Primaria",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.radioButtonSecundaria:
                            Toast.makeText(MainActivity.this,"Secundaria",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.radioButtonPreparatoria:
                            Toast.makeText(MainActivity.this,"Preparatoria",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.radioButtonUniversidad:
                            Toast.makeText(MainActivity.this,"Universidad",Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

            }
        });


    }

    public String verificarPeliculas (){
        if (!checkBoxTerror.isChecked() && !checkBoxAccion.isChecked() && !checkBoxComedias.isChecked() && !checkBoxRomanticas.isChecked()) {
            return "No se sleccionó película";
        } else {
            String pelis = "Favoritas:";
            if (checkBoxTerror.isChecked()) {
                pelis += " " + checkBoxTerror.getText().toString();
            }
            if (checkBoxAccion.isChecked()) {
                pelis += " " + checkBoxAccion.getText().toString();
            }
            if (checkBoxComedias.isChecked()) {
                pelis += " " + checkBoxComedias.getText().toString();
            }
            if (checkBoxRomanticas.isChecked()) {
                pelis += " " + checkBoxRomanticas.getText().toString();
            }
            return pelis;
        }

    }
}
