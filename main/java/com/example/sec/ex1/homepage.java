package com.example.sec.ex1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.nio.channels.InterruptedByTimeoutException;

/**
 * Created by SEC on 2017-10-16.
 */

public class homepage extends AppCompatActivity{
    Button b_chal;

    protected void onCreate(Bundle  savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        b_chal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
