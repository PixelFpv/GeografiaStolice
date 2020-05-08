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
    Integer count = 0;
    //TextView tv3;
    FloatingActionButton fab;
    Integer random = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        fab = findViewById(R.id.fab);
        //tv3 = findViewById(R.id.textView3);
        //tv3.setText(count.toString());

        if (et.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        }
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
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
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
