package com.example.magicball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ball;
    private TextView respuesta;
    private String[] respuestaArray ={"Puede Ser","Pero Por Supuesto","No lo se","Pregunta de Nuevo","50 y 50","Claro que si",
                                        "Definitivamente puede no ser", "NO", "Si", "Estoy ocupado, pregunta mas tarde", "Dudoso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencia la Imagen
        ball = findViewById(R.id.btn);

        //Referencia al Texto
        respuesta = findViewById(R.id.respuestaVista);

        ball.setOnClickListener(this);
        Toast.makeText(MainActivity.this, "Consulta tu destino", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v){

        //Creación Metotodo Switch
        switch (v.getId()){
            case R.id.btn:
                int rand = new Random().nextInt(respuestaArray.length);
                respuesta.setText(respuestaArray[rand]);
                break;
        }

        //Para Cerrar el Teclado una Vez presioando el boton
        cerrarTeclado();
    }

    private void cerrarTeclado() {
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            input.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}