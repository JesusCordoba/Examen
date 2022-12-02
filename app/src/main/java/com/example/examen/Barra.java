package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Barra extends AppCompatActivity {

    Button next_br;
    Button previous_br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra);

        next_br = (Button) findViewById(R.id.next_br);
        next_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        previous_br = (Button) findViewById(R.id.previus_br);
        previous_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir_radiobtn = new Intent(Barra.this, Radiobtn.class);
                Barra.this.startActivity(ir_radiobtn);
            }
        });
    }
}