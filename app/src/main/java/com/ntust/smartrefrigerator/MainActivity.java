package com.ntust.smartrefrigerator;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Put food button
        final Button pushFood = (Button) findViewById(R.id.pushFood);
        pushFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PushFoodActivity.class);
                startActivity(intent);
            }
        });

        //Pop food button
        final Button popFood = (Button) findViewById(R.id.popFood);
        popFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PopFoodActivity.class);
                startActivity(intent);
            }
        });

        Button sendMessage = (Button) findViewById(R.id.sendMessage);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CheckFoodActivity.class);
                startActivity(intent);
            }
        });

    }





}
