package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.examen.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    private Button sign_in;
    private EditText email;
    private EditText password;
    private TextView sesion;
    private String sesion_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Intent intent = getIntent();
        String correo = "";
        correo = intent.getStringExtra("email");
        sesion_txt = "";
        sesion_txt = intent.getStringExtra("sign");
        sesion = (TextView) findViewById(R.id.sesion);
        sesion.setText(sesion_txt);


        email = (EditText) findViewById(R.id.email_registro);
        email.setText(correo);

        password = (EditText) findViewById(R.id.password_registro);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password_texto = password.getText().toString();
                validar(password_texto);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sign_in = (Button) findViewById(R.id.sing_in);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si el usuario a entrado sin email se creara un usuario y le pedira el usuario para entrar a la aplicacion
                if(sesion_txt.equals("Registro")){

                    SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);


                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    myEdit.putString("email", email.getText().toString());
                    myEdit.putString("password", password.getText().toString());

                    myEdit.commit();
                    sesion_txt = "Iniciar sesion";
                    sesion.setText(sesion_txt);
                    email.setText("");
                    password.setText("");
                    sign_in.setEnabled(false);
                }else if(sesion_txt.equals("Iniciar sesion")){

                    SharedPreferences sh = getSharedPreferences("Login", Context.MODE_PRIVATE);
                    String email_guardado = sh.getString("email", null);
                    String password_guardado = sh.getString("password", null);
                    String email_texto = String.valueOf(email.getText());
                    String password_texto = String.valueOf(password.getText());
                    if (email_guardado.equals(email_texto) && password_guardado.equals(password_texto)){
                        Intent ir_preguntas = new Intent(Registro.this, CheckBox.class);
//                        ir_registro.putExtra("email", email_guardado);
//                        ir_registro.putExtra("sign", "Iniciar sesion");
                        Registro.this.startActivity(ir_preguntas);
                    }

                }

            }
        });
    }

    public void validar(String texto){

        // check for pattern
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");
        int cont = 0;

        if (lowercase.matcher(texto).find()) {
            cont++;
        }

        if (uppercase.matcher(texto).find()) {
            cont++;
        }
        if (digit.matcher(texto).find()) {
            cont++;
        }
        if (texto.length() > 8) {
            cont++;
        }

        if(cont == 4){
            sign_in.setEnabled(true);
            password.setTextColor(Color.GREEN);
        }else{
            sign_in.setEnabled(false);
            password.setTextColor(Color.RED);
        }


    }
}