package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.checkbox.MaterialCheckBox;

public class CheckBox extends AppCompatActivity {
    MaterialCheckBox read_chk;
    MaterialCheckBox workout_chk;
    MaterialCheckBox draw_chk;
    MaterialCheckBox play_chk;
    TextView mostrarchk;
    Button next_btn;
    int progreso = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mostrarchk = (TextView) findViewById(R.id.mostrar_chk);

        read_chk = (MaterialCheckBox) findViewById(R.id.read_chk);
        read_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progreso++;
//                mostrarchk.setText(read_chk.getText() + " " + read_chk.getCheckedState());
            }
        });

        workout_chk = (MaterialCheckBox) findViewById(R.id.workout_chk);
        workout_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progreso++;
//                mostrarchk.setText(workout_chk.getText() + " " + workout_chk.getCheckedState());
            }
        });

        draw_chk = (MaterialCheckBox) findViewById(R.id.draw_chk);
        draw_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progreso++;
//                mostrarchk.setText(draw_chk.getText() + " " + draw_chk.getCheckedState());
            }
        });

        play_chk = (MaterialCheckBox) findViewById(R.id.play_chk);
        play_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progreso++;
//                mostrarchk.setText(play_chk.getText() + " " + play_chk.getCheckedState());
            }
        });

        next_btn = (Button) findViewById(R.id.next_chk);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progreso++;
                Intent ir_radiobtn = new Intent(CheckBox.this, Radiobtn.class);
                CheckBox.this.startActivity(ir_radiobtn);
            }
        });



    }

}