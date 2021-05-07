package com.descontron.lottotron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textExtract;
    private TextView textExtract1;
    private TextView textExtract2;
    private TextView textExtract3;
    private TextView textExtract4;

    private ImageView ballExtract;
    private ImageView ballExtract1;
    private ImageView ballExtract2;
    private ImageView ballExtract3;
    private ImageView ballExtract4;

    private final int[] textOutput = new int[]{
            R.id.text_extract,
            R.id.text_extract1,
            R.id.text_extract2,
            R.id.text_extract3,
            R.id.text_extract4};

    private final int[] ballOutput = new int[]{
            R.id.ball_extract,
            R.id.ball_extract1,
            R.id.ball_extract2,
            R.id.ball_extract3,
            R.id.ball_extract4};

    private Button btnDraw;

    int numOfNumbers = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDraw = findViewById(R.id.button_draw);

        textExtract = findViewById(R.id.text_extract);
        textExtract1 = findViewById(R.id.text_extract1);
        textExtract2 = findViewById(R.id.text_extract2);
        textExtract3 = findViewById(R.id.text_extract3);
        textExtract4 = findViewById(R.id.text_extract4);

        ballExtract = findViewById(R.id.ball_extract);
        ballExtract1 = findViewById(R.id.ball_extract1);
        ballExtract2 = findViewById(R.id.ball_extract2);
        ballExtract3 = findViewById(R.id.ball_extract3);
        ballExtract4 = findViewById(R.id.ball_extract4);




        btnDraw.setOnClickListener(new View.OnClickListener() {

            private Random rnd = new Random();
            private List<Integer> numberDraw = new ArrayList<>();
            int count = 0;


            @Override
            public void onClick(View v) {

                while(count< numOfNumbers){

                    for(int i=0; i< numOfNumbers; i++) {
                        Log.i("RND", "Randon value" + i + " -> " + + (rnd.nextInt(50) + 1));
                        count++;
                    }

                }




            }
        });

    }
}