package com.descontron.lottotron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private TextView[] textExtract;

    private ImageView[] ballExtract;


    private Button btnDraw;

    int numOfNumbers = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textExtract = new TextView[]{
                findViewById(R.id.text_extract),
                findViewById(R.id.text_extract1),
                findViewById(R.id.text_extract2),
                findViewById(R.id.text_extract3),
                findViewById(R.id.text_extract4)};

        btnDraw = findViewById(R.id.button_draw);

        ballExtract = new ImageView[]{
                findViewById(R.id.ball_extract),
                findViewById(R.id.ball_extract1),
                findViewById(R.id.ball_extract2),
                findViewById(R.id.ball_extract3),
                findViewById(R.id.ball_extract4)
        };



        btnDraw.setOnClickListener(new View.OnClickListener() {

            private Random rnd = new Random();
            int numberDraw;
            private List<Integer> numbersDraw = new ArrayList<>();
            int count = 0;


            @Override
            public void onClick(View v) {

                while(count< numOfNumbers){
                    numberDraw = rnd.nextInt(50)+1;

                    if(!numbersDraw.contains(numberDraw)){
                        numbersDraw.add(numberDraw);
                        count++;
                    }
                }

                Collections.sort(numbersDraw);

                for(int i=0; i < numOfNumbers; i++) {
                    textExtract[i].setText(numbersDraw.get(i).toString());
                    textExtract[i].setVisibility(View.VISIBLE);
                    ballExtract[i].setVisibility(View.VISIBLE);



                }




            }
        });

    }
}