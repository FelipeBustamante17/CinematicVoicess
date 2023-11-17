package com.santotomas.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btnPeliculas;

    Button btnMapa;

    Button btnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnPeliculas = findViewById(R.id.btn_Peliculas);
        btnMapa = findViewById(R.id.btn_Mapa);
        btnSalir = findViewById(R.id.btn_salir);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentr = new Intent(Inicio.this, MainActivity.class);
                startActivity(intentr);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(Inicio.this, MapaCines.class);
                startActivity(inte);
            }
        });


        btnPeliculas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent(Inicio.this, Pelicula.class);
                startActivity(intent);
            }
        });



    }
}