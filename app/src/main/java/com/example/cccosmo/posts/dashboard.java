package com.example.cccosmo.posts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {
    private Button light, gate , temp, gyser, garage, alarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dashboard );

        light = findViewById ( R.id.lights );
        gate = findViewById ( R.id.gate );
        temp = findViewById ( R.id.temperature );
        gyser = findViewById ( R.id.gyser );
        garage = findViewById ( R.id.garage );
        alarms = findViewById ( R.id.alarms );
 
        light.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( dashboard.this , lights.class );
                startActivity(intent);
            }
        } );

        gate.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view){
                Toast.makeText ( getApplicationContext(), "Gate", Toast.LENGTH_SHORT ).show ();
            }
        });

        temp.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View view){
                Toast.makeText ( getApplicationContext(), "Temperature", Toast.LENGTH_SHORT ).show ();
            }
        } );

        gyser.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View view){
                Toast.makeText ( getApplicationContext(), "Gyser", Toast.LENGTH_SHORT ).show ();
            }
        } );

        garage.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View view){
                Toast.makeText ( getApplicationContext(), "Garage", Toast.LENGTH_SHORT ).show ();
            }
        } );

        alarms.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View view){
                Toast.makeText ( getApplicationContext(), "Alarms", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
}
