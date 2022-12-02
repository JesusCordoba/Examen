package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examen.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.continueInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si el email puesto es el guardado se va a iniciar sesion en caso de que no el usuario se registrara

                SharedPreferences sh = getSharedPreferences("Login", Context.MODE_PRIVATE);
                String email_guardado = sh.getString("email", null);
                String password_guardado = sh.getString("password", null);
                String email = String.valueOf(binding.emailInicio.getText());
                if (email_guardado.equals(email)){
                    Intent ir_registro = new Intent(MainActivity.this, Registro.class);
                    ir_registro.putExtra("email", email_guardado);
                    ir_registro.putExtra("sign", "Iniciar sesion");
                    MainActivity.this.startActivity(ir_registro);
                }else{
                    Intent ir_registro = new Intent(MainActivity.this, Registro.class);
                    ir_registro.putExtra("email", "");
                    ir_registro.putExtra("sign", "Registro");
                    MainActivity.this.startActivity(ir_registro);
                }
                //binding.subtituloInicio.setText(email_guardado + " " + password_guardado);

            }
        });

        binding.signInGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir_registro = new Intent(MainActivity.this, CheckBox.class);
                MainActivity.this.startActivity(ir_registro);
            }
        });
    }
}