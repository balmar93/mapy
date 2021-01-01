package com.example.fetchapi.api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fetchapi.R;

public class Userscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userscreen);
        Button button = (Button) findViewById(R.id.button);


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openNewActivity();
                    }
                });
            }
            public void openNewActivity(){
                Intent intent = new Intent(this, MapsActivityCurrentPlace.class);
                startActivity(intent);
            }
        }
