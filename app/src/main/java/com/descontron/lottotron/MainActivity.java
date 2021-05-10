package com.descontron.lottotron;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView[] textExtract;
    private ImageView[] ballExtract;
    private Button btnSorteio;
    private TextView textPercent;

    int numOfNumbers = 5;

    public void validaCorreto(int n, Context ct) {
        if ((n == 0) || (n > 50)) {
            Toast toast = Toast.makeText(ct, "Digite valores entre 1 e 50", 30);
            toast.show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText Edt1, Edt2, Edt3, Edt4, Edt5;

        setContentView(R.layout.activity_main);
        Context contexto = this;
        textExtract = new TextView[]{
                findViewById(R.id.text_extract),
                findViewById(R.id.text_extract1),
                findViewById(R.id.text_extract2),
                findViewById(R.id.text_extract3),
                findViewById(R.id.text_extract4)};

        textPercent = findViewById(R.id.text_percent);

        ballExtract = new ImageView[]{
                findViewById(R.id.ball_extract),
                findViewById(R.id.ball_extract1),
                findViewById(R.id.ball_extract2),
                findViewById(R.id.ball_extract3),
                findViewById(R.id.ball_extract4)};

        Edt1 = (EditText) findViewById(R.id.text_input_num1); Edt2 = (EditText) findViewById(R.id.text_input_num2);
        Edt3 = (EditText) findViewById(R.id.text_input_num3); Edt4 = (EditText) findViewById(R.id.text_input_num4);
        Edt5 = (EditText) findViewById(R.id.text_input_num5); btnSorteio = (Button) findViewById(R.id.button_draw);
        Edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
              public void onFocusChange(View v, boolean hasFocus) {
                  if ((!hasFocus) && (! Edt1.getText().toString().equals(""))) {
                      int numero1;
                      numero1 = Integer.parseInt(Edt1.getText().toString());
                      validaCorreto(numero1,contexto);
                  }
              }
          });
        Edt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt2.getText().toString().equals(""))) {
                    int numero2;
                    numero2 = Integer.parseInt(Edt2.getText().toString());
                    validaCorreto(numero2,contexto);
                }
            }
          });
        Edt3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt3.getText().toString().equals(""))) {
                    int numero3;
                    numero3 = Integer.parseInt(Edt3.getText().toString());
                    validaCorreto(numero3,contexto);
                }
            }
        });
        Edt4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt4.getText().toString().equals(""))) {
                    int numero4;
                    numero4 = Integer.parseInt(Edt4.getText().toString());
                    validaCorreto(numero4,contexto);
                }
            }
        });
        Edt5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt5.getText().toString().equals(""))) {
                    int numero5;
                    numero5 = Integer.parseInt(Edt5.getText().toString());
                    validaCorreto(numero5,contexto);
                }
            }
        });
        btnSorteio.setOnClickListener(new View.OnClickListener() {
            private Random rnd = new Random();
            int numberDraw;
            private List<Integer> numbersDraw = new ArrayList<>();
            int count = 0;
            int acertos = 0;



            @Override
            public void onClick(View v) {
                int n1,n2,n3,n4,n5;
                List<Integer> nums = new ArrayList<>();
                if ((! Edt1.getText().toString().equals("")) && (! Edt2.getText().toString().equals("")) && (! Edt3.getText().toString().equals("")) && (! Edt4.getText().toString().equals("")) && (! Edt5.getText().toString().equals(""))) {
                    nums.add(Integer.parseInt(Edt1.getText().toString()));
                    nums.add(Integer.parseInt(Edt2.getText().toString()));
                    nums.add(Integer.parseInt(Edt3.getText().toString()));
                    nums.add(Integer.parseInt(Edt4.getText().toString()));
                    nums.add(Integer.parseInt(Edt5.getText().toString()));
                    if ((nums.get(0) <= 50) && (nums.get(1) <= 50) && (nums.get(2) <= 50) && (nums.get(3) <= 50) && (nums.get(4) <= 50)) {
                        if ((nums.get(0) != nums.get(1)) && (nums.get(0) != nums.get(2)) && (nums.get(0) != nums.get(3)) && (nums.get(0) != nums.get(4))) {
                            if ((nums.get(1) != nums.get(2)) && (nums.get(1) != nums.get(3)) && (nums.get(1) != nums.get(4))) {
                                if ((nums.get(2) != nums.get(3)) && (nums.get(2) != nums.get(4))) {
                                    if ((nums.get(3) != nums.get(4))) {

                                        // POnto onde todas as validações estao ok e o sorteio pode ser feito
                                        // Numeros escolhidos sao: n1, n2, n3, n4, n5

                                        Toast toast = Toast.makeText(contexto, "Numeros diferentes, ok !", 30);
                                        Edt5.setTextColor(Color.BLACK);
                                        toast.show();

                                        while(count< numOfNumbers){
                                            //numberDraw = rnd.nextInt(50)+1;
                                            numberDraw = count+1;

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
                                        for(int i=0; i < numOfNumbers;i++){
                                            if(nums.contains(numbersDraw.get(i))){
                                                textExtract[i].setTextColor(Color.parseColor("#FF0000"));
                                                acertos++;
                                            }
                                        }

                                        textPercent.setText(acertos + " acertos");
                                        textPercent.setVisibility(View.VISIBLE);

                                    }
                                }
                            }

                        } else {
                            Toast toast = Toast.makeText(contexto, "Numeros devem ser diferentes", 30);
                            toast.show();
                        }
                    } else {
                        Toast toast = Toast.makeText(contexto, "Digite valores entre 1 e 50", 30);
                        toast.show();
                    }
                } else {
                        Toast toast = Toast.makeText(contexto, "Por favor, preencha todos os campos", 30);
                        toast.show();
                }


            }
        });
    }
}
