package com.santotomas.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Button btnLogin;

    Button invitado;

    Button btnRegistrarse;
    EditText etUsername, etPwd;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        etUsername = findViewById(R.id.email2);
        etPwd = findViewById(R.id.pwd2);
        btnLogin = findViewById(R.id.btn_inicio);
        invitado = findViewById(R.id.anonimo);
        btnRegistrarse = findViewById(R.id.btn_siguiente);

        invitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(MainActivity.this, Inicio.class);
                startActivity(intenta);
            }
        });
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean logged = dbHelper.checkUser(etUsername.getText().toString(), etPwd.getText().toString());
                if(logged){
                    Intent intents = new Intent(MainActivity.this, Inicio.class);
                    startActivity(intents);
                }else{
                    Toast.makeText(MainActivity.this, "Error al iniciar sesión", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}