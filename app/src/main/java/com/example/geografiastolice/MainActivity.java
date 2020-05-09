package com.example.geografiastolice;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    String kraj[] = {"Czechy", "Słowacja", "Węgry", "Rumunia", "Bułgaria", "Rosja", "Litwa", "Łotwa", "Estonia", "Białoruś", "Ukraina", "Austria", "Polska", "Dania"};
    String stolica[] = {"Praga", "Bratysława", "Budapeszt", "Bukareszt", "Sofia", "Moskwa", "Wilno", "Ryga", "Tallin", "Mińsk", "Kijów", "Wiedeń", "Warszawa", "Kopenhaga"};
    TextView tv;
    EditText et;
    Button odp1;
    Button odp2;
    Button odp3;

    Integer count = 0;
    FloatingActionButton fab;
    Integer random = 0;
    Integer ranB = new Random().nextInt(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        fab = findViewById(R.id.fab);
        odp1 = findViewById(R.id.button1);
        odp2 = findViewById(R.id.button2);
        odp3 = findViewById(R.id.button3);

        String ran1 = stolica[new Random().nextInt(14)];
        String ran2 = stolica[new Random().nextInt(14)];
        if (ranB == 0) {
            odp1.setText(stolica[random]);
            odp2.setText(stolica[new Random().nextInt(14)]);
            odp3.setText(stolica[new Random().nextInt(14)]);
            ranB = new Random().nextInt(3);
        }

        if (ranB == 1){
            odp2.setText(stolica[random]);
            odp1.setText(stolica[new Random().nextInt(14)]);
            odp3.setText(stolica[new Random().nextInt(14)]);
            ranB = new Random().nextInt(3);
        }

        if (ranB == 2){
            odp3.setText(stolica[random]);
            odp1.setText(stolica[new Random().nextInt(14)]);
            odp2.setText(stolica[new Random().nextInt(14)]);
            ranB = new Random().nextInt(3);
        }

            odp1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (odp1.getText().toString() == stolica[random]) {
                        random = new Random().nextInt(14);
                        ranB = new Random().nextInt(3);
                        if (ranB == 0) {
                            odp1.setText(stolica[random]);
                            odp2.setText(stolica[new Random().nextInt(14)]);
                            odp3.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(3);
                        }

                        if (ranB == 1){
                            odp2.setText(stolica[random]);
                            odp1.setText(stolica[new Random().nextInt(14)]);
                            odp3.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(3);
                        }
                        if (ranB == 2){
                            odp3.setText(stolica[random]);
                            odp1.setText(stolica[new Random().nextInt(14)]);
                            odp2.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(3);
                        }
                        tv.setText(kraj[random]);
                        tv.setBackgroundColor(getColor(R.color.green));
//                        odp2.setBackgroundColor(getColor(R.color.red));
                    }else {
                        tv.setBackgroundColor(getColor(R.color.red));

                    }

                }
            });

            odp2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (odp2.getText().toString() == stolica[random]) {
                        random = new Random().nextInt(14);
                        ranB = new Random().nextInt(3);
                        if (ranB == 0) {
                            odp1.setText(stolica[random]);
                            odp2.setText(stolica[new Random().nextInt(14)]);
                            odp3.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(2);
                        }

                        if (ranB == 1) {
                            odp2.setText(stolica[random]);
                            odp1.setText(stolica[new Random().nextInt(14)]);
                            odp3.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(2);
                        }
                        if (ranB == 2) {
                            odp3.setText(stolica[random]);
                            odp1.setText(stolica[new Random().nextInt(14)]);
                            odp2.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(3);
                        }
                        tv.setText(kraj[random]);
                        tv.setBackgroundColor(getColor(R.color.green));
//                        odp1.setBackgroundColor(getColor(R.color.red));
                    }else {
                        tv.setBackgroundColor(getColor(R.color.red));

                    }
                }
                });


            odp3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (odp3.getText().toString() == stolica[random]) {
                        random = new Random().nextInt(14);
                        ranB = new Random().nextInt(3);
                        if (ranB == 0) {
                            odp1.setText(stolica[random]);
                            odp2.setText(stolica[new Random().nextInt(14)]);
                            odp3.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(2);
                        }

                        if (ranB == 1) {
                            odp2.setText(stolica[random]);
                            odp1.setText(stolica[new Random().nextInt(14)]);
                            odp3.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(2);
                        }
                        if (ranB == 2) {
                            odp3.setText(stolica[random]);
                            odp1.setText(stolica[new Random().nextInt(14)]);
                            odp2.setText(stolica[new Random().nextInt(14)]);
                            ranB = new Random().nextInt(3);
                        }
                        tv.setText(kraj[random]);
                        tv.setBackgroundColor(getColor(R.color.green));
//                        odp1.setBackgroundColor(getColor(R.color.red));
                    }else {
                        tv.setBackgroundColor(getColor(R.color.red));

                    }
                }
            });



        //if (et.requestFocus()) {
          //  getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//        }
         tv.setText(kraj[random]);

        final String Sto = stolica[random].toString();
        final char first = Sto.charAt(0);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.requestFocus();
                et.setHint(stolica[random]);
               // et.setHint("h");
            }
        });


        et.setOnKeyListener(new View.OnKeyListener() {
            String ett = et.getText().toString();
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    et.clearFocus();
                    et.setHint("Odpowiedź");
                    if (stolica[random].equals(et.getText().toString())) {
                        //System.out.println(random);
                        //System.out.println(et.getText().toString());
                        et.clearFocus();
//                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                        et.setBackgroundColor(getColor(R.color.green));
                        et.setText("");
                         random = new Random().nextInt(15);
                        //random++;


                        tv.setText(kraj[random]);
                        //tv3.setText("cou");
                        et.requestFocus();


                    }else {
                        //et.clearFocus();
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                        et.setBackgroundColor(getColor(R.color.red));
                        et.setText("");
                        et.setHint("Jeszcze raz!");
                        et.requestFocus();
                        //count--;
                        //tv3.setText("cou");

                    }



                    }

                return false;
            }

        });

    }
}
