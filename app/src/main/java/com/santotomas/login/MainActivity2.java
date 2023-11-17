package com.santotomas.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    EditText etUser, etPwd, etRepwd;
    Button btnRegister, btnRegresar;

    DBHelper dbHelper;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etUser = findViewById(R.id.email);
        etPwd = findViewById(R.id.contra);
        etRepwd = findViewById(R.id.contra2);
        btnRegister = findViewById(R.id.registro);
        dbHelper = new DBHelper(this);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, pwd, rePwd;
                user = etUser.getText().toString();
                pwd = etPwd.getText().toString();
                rePwd = etRepwd.getText().toString();
                if(user.equals("") || pwd.equals("") || rePwd.equals("")){
                    Toast.makeText(MainActivity2.this, "Porfavor completar todos los campos", Toast.LENGTH_LONG).show();
                } else{
                    if(pwd.equals(rePwd)){
                        if(dbHelper.checkUsername(user)){
                            Toast.makeText(MainActivity2.this, "Usuario ya existe", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean registeredSuccess = dbHelper.insertData(user, pwd);
                        if(registeredSuccess)
                            Toast.makeText(MainActivity2.this, "Usuario creado exitosamente", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity2.this, "Error al crear el usuario", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity2.this, "Contraseñas no coinciden", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}