package com.descontron.lottotron;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        Button btnSorteio;
        setContentView(R.layout.activity_main);
        Context contexto = this;
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
            @Override
            public void onClick(View v) {
                int n1,n2,n3,n4,n5;
                if ((! Edt1.getText().toString().equals("")) && (! Edt2.getText().toString().equals("")) && (! Edt3.getText().toString().equals("")) && (! Edt4.getText().toString().equals("")) && (! Edt5.getText().toString().equals(""))) {
                    n1 = Integer.parseInt(Edt1.getText().toString());
                    n2 = Integer.parseInt(Edt2.getText().toString());
                    n3 = Integer.parseInt(Edt3.getText().toString());
                    n4 = Integer.parseInt(Edt4.getText().toString());
                    n5 = Integer.parseInt(Edt5.getText().toString());
                    if ((n1 <= 50) && (n2 <= 50) && (n3 <= 50) && (n4 <= 50) && (n5 <= 50)) {
                        if ((n1 != n2) && (n1 != n3) && (n1 != n4) && (n1 != n5)) {
                            if ((n2 != n3) && (n2 != n4) && (n2 != n5)) {
                                if ((n3 != n4) && (n3 != n5)) {
                                    if ((n4 != n5)) {

                                        // POnto onde todas as validações estao ok e o sorteio pode ser feito
                                        // Numeros escolhidos sao: n1, n2, n3, n4, n5

                                        Toast toast = Toast.makeText(contexto, "Numeros diferentes, ok !", 30);
                                        Edt5.setTextColor(Color.BLACK);
                                        toast.show();
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
