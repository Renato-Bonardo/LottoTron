package com.descontron.lottotron;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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


    /*

    Alunos do grupo:

    * Antonio Eduardo Kronitzky de Melo
    * Everton Gomes de Moraes
    * Renato José Bonardo

     */
    private TextView[] textExtract;
    private Context contexto;
    private ImageView[] ballExtract;
    private EditText Edt1, Edt2, Edt3, Edt4, Edt5;
    private Button btnSorteio;
    private TextView textPercent, textResult;
    private List<Integer> numbersDraw = new ArrayList<>();
    private MediaPlayer audioBolinha;
    private MediaPlayer audioAplausos;
    private int count;
    private int acertos;

    int numOfNumbers = 5;
    private Handler handler = new Handler();
    int iterador = 1;
    int delay = 5000;

    public void validaCorreto(int n,EditText edt, Context ct) {
        if ((n == 0) || (n > 50)) {
            Toast toast = Toast.makeText(ct, R.string.erro_texto, 30);
            toast.show();
            edt.setTextColor(Color.parseColor("#FF0000"));

        }else{
            edt.setTextColor(Color.parseColor("#000000"));
        }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        contexto = this;
        audioBolinha = MediaPlayer.create(MainActivity.this, R.raw.audio_bolinha);
        audioAplausos = MediaPlayer.create(MainActivity.this, R.raw.aplausos);
        textExtract = new TextView[]{
                findViewById(R.id.text_extract),
                findViewById(R.id.text_extract1),
                findViewById(R.id.text_extract2),
                findViewById(R.id.text_extract3),
                findViewById(R.id.text_extract4)};

        textPercent = findViewById(R.id.text_percent);
        textResult = findViewById(R.id.text_result);

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
                      validaCorreto(numero1,Edt1, contexto);
                  }
              }
          });
        Edt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt2.getText().toString().equals(""))) {
                    int numero2;
                    numero2 = Integer.parseInt(Edt2.getText().toString());
                    validaCorreto(numero2,Edt2, contexto);
                }
            }
          });
        Edt3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt3.getText().toString().equals(""))) {
                    int numero3;
                    numero3 = Integer.parseInt(Edt3.getText().toString());
                    validaCorreto(numero3,Edt3, contexto);
                }
            }
        });
        Edt4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt4.getText().toString().equals(""))) {
                    int numero4;
                    numero4 = Integer.parseInt(Edt4.getText().toString());
                    validaCorreto(numero4,Edt4,contexto);
                }
            }
        });
        Edt5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus) && (! Edt5.getText().toString().equals(""))) {
                    int numero5;
                    numero5 = Integer.parseInt(Edt5.getText().toString());
                    validaCorreto(numero5,Edt5, contexto);

                }
            }
        });

        btnSorteio.setOnClickListener(actionSorteio);

    }


    private View.OnClickListener actionSorteio = new View.OnClickListener() {

        private Random rnd = new Random();
        int numberDraw;

        @Override
        public void onClick(View v) {

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

                                    // Ponto onde todas as validações estao ok e o sorteio pode ser feito
                                    btnSorteio.setEnabled(false);

                                    while(count< numOfNumbers){
                                        numberDraw = rnd.nextInt(50)+1;
                                        //Para testar acertar todos os número comentar a linha acima e descomentar a linha abaixo
                                        //numberDraw = count+1;

                                        if(!numbersDraw.contains(numberDraw)){
                                            numbersDraw.add(numberDraw);
                                            count++;
                                        }

                                    }

                                    Collections.sort(numbersDraw);

                                    audioBolinha.start();
                                    textExtract[0].setText(numbersDraw.get(0).toString());
                                    textExtract[0].setVisibility(View.VISIBLE);
                                    ballExtract[0].setVisibility(View.VISIBLE);

                                    for(int i=1; i < numOfNumbers; i++) {
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                audioBolinha.start();
                                                textExtract[iterador].setText(numbersDraw.get(iterador).toString());
                                                textExtract[iterador].setVisibility(View.VISIBLE);
                                                ballExtract[iterador].setVisibility(View.VISIBLE);
                                                iterador++;
                                            }
                                        }, delay);
                                        delay +=5000;
                                    }


                                    for(int i=0; i < numOfNumbers;i++){
                                        if(nums.contains(numbersDraw.get(i))){
                                            textExtract[i].setTextColor(Color.parseColor("#FF0000"));
                                            acertos++;
                                        }
                                    }

                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            textPercent.setText(acertos + " acertos");
                                            textResult.setVisibility(View.VISIBLE);
                                            textPercent.setVisibility(View.VISIBLE);
                                            if(acertos == numOfNumbers){
                                                showVencedor();
                                                audioAplausos.start();

                                            }
                                            btnSorteio.setEnabled(true);
                                        }
                                    }, 20000);

                                    btnSorteio.setText("Reset");
                                    btnSorteio.setOnClickListener(resetSorteio);
                                }
                            }
                        }

                    } else {
                        Toast toast = Toast.makeText(contexto,R.string.numeros_diferentes, 30);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(contexto, R.string.erro_texto, 30);
                    toast.show();
                }
            } else {
                Toast toast = Toast.makeText(contexto, R.string.falta_numeros, 30);
                toast.show();
            }
        }
    };
    private View.OnClickListener resetSorteio = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            for(int i=0; i < numOfNumbers; i++) {

                textExtract[i].setVisibility(View.INVISIBLE);
                textExtract[i].setTextColor(Color.parseColor("#000000"));
                ballExtract[i].setVisibility(View.INVISIBLE);
            }

            count = 0;
            acertos = 0;
            iterador = 1;
            delay = 5000;
            numbersDraw.clear();
            Edt1.setText("");
            Edt2.setText("");
            Edt3.setText("");
            Edt4.setText("");
            Edt5.setText("");
            textResult.setVisibility(View.INVISIBLE);
            textPercent.setVisibility(View.INVISIBLE);
            btnSorteio.setText("Sorteio");
            btnSorteio.setOnClickListener(actionSorteio);
        }
    };

    private void showVencedor(){

        View view = getLayoutInflater().inflate(R.layout.alert, null);
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);
        alertDialog = builder.create();
        alertDialog.show();

        view.findViewById(R.id.img_vencedor).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                audioAplausos.pause();
                alertDialog.dismiss();

            }
        });
    }
}



