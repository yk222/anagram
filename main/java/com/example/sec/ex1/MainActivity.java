package com.example.sec.ex1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_info;
    TextView tv_word;
    EditText et_guess;
    Button b_check, b_new, b_home;
    Random r;
    String currentWord;

    String[] dictionary = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.tv_word);
        et_guess = (EditText) findViewById(R.id.et_guess);
        b_check = (Button) findViewById(R.id.b_check);
        b_new = (Button) findViewById(R.id.b_new);
        b_home = (Button) findViewById(R.id.b_home);
        r = new Random();
        newGame();

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Awesome!");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);
                }

            }
        });

        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });

        b_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), homepage.class);
                startActivity(intent);

            }
        });

    }

    private String shuffleWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

    private void newGame(){
        currentWord = dictionary[r.nextInt(dictionary.length)];
        tv_word.setText(shuffleWord(currentWord));
        et_guess.setText("");
        b_new.setEnabled(false);
        b_check.setEnabled(true);
    }
}

