package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Radiobtn extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup films;
    TextView mostrarchk;
    Button next_btn;
    Button previous_btn;
    int progreso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mostrarchk = (TextView) findViewById(R.id.mostrar_rbtn);
        setContentView(R.layout.activity_radiobtn);
        films = (RadioGroup) findViewById(R.id.films);
        films.setOnCheckedChangeListener(this);

        next_btn = (Button) findViewById(R.id.next_rd);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir_radiobtn = new Intent(Radiobtn.this, Barra.class);
                Radiobtn.this.startActivity(ir_radiobtn);
            }
        });
        previous_btn = (Button) findViewById(R.id.previus_rd);
        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir_chek = new Intent(Radiobtn.this, CheckBox.class);
                Radiobtn.this.startActivity(ir_chek);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.star_trek:
//                mostrarchk.setText("star trek");
                break;

            case R.id.social_network:
//                mostrarchk.setText("social network");
                break;

            case R.id.future:
//                mostrarchk.setText("back to the future");
                break;

            case R.id.outbreak:
//                mostrarchk.setText("outbreak");
                break;

        }
    }
}