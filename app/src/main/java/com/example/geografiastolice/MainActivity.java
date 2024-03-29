package com.example.geografiastolice;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> kraj = new ArrayList<>();
    ArrayList<String> stolica = new ArrayList<>();


    TextView tv;
    TextView pointT;
    TextView pointF;
    TextView hint_L;
    EditText et;
    ImageView im;
    Button odp1;
    Button odp2;
    Button odp3;

    Integer count = 0,wielkosc;
    boolean hint_= true;
    FloatingActionButton fab;
    Integer random = new Random().nextInt(14);
    Integer ranB = new Random().nextInt(3);
    Integer hintlicznik = 1;
    int count_t = 0;
    int count_f = 0;



    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("kraje_pl.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch ( IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

void WczytajZmienne(){
    try {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray userArray = obj.getJSONArray("kraje");
        for (int i = 0; i < userArray.length(); i++) {
            JSONObject userDetail = userArray.getJSONObject(i);
            kraj.add(userDetail.getString("panstwo"));
            stolica.add(userDetail.getString("stolica"));
            wielkosc = kraj.size()-1;
        }
    } catch ( JSONException e) {
        e.printStackTrace();
    }
}


    void allButtonsOK() {

//        tu masz przykład ja zatrzymac wykonanie czegoś na jakis czas
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                // yourMethod();
//                odp1.setBackgroundResource(R.drawable.button_background);
//                odp2.setBackgroundResource(R.drawable.button_background);
//                odp3.setBackgroundResource(R.drawable.button_background);
//                tv.setBackgroundColor(getColor(R.color.white));
//            }
//        }, 2000);   //2 seconds

        odp1.setBackgroundResource(R.drawable.button_background);
        odp2.setBackgroundResource(R.drawable.button_background);
        odp3.setBackgroundResource(R.drawable.button_background);
        tv.setBackgroundColor(getColor(R.color.white));
    }

    void hint(){
        int ranZb = new Random().nextInt(2);
        if (odp1.getText().toString() == stolica.get(random)){
            if (ranZb == 0){
                odp2.setBackgroundResource(R.drawable.button_red);
            }
            if (ranZb == 1){
                odp3.setBackgroundResource(R.drawable.button_red);
            }

        }
        if (odp2.getText().toString() == stolica.get(random)){
            if (ranZb == 0){
                odp1.setBackgroundResource(R.drawable.button_red);
            }
            if (ranZb == 1){
                odp3.setBackgroundResource(R.drawable.button_red);
            }

        }
        if (odp3.getText().toString() == stolica.get(random)){
            if (ranZb == 0){
                odp1.setBackgroundResource(R.drawable.button_red);
            }
            if (ranZb == 1){
                odp2.setBackgroundResource(R.drawable.button_red);
            }

        }

    }

    void ify(){
        random = new Random().nextInt(wielkosc);
        allButtonsOK();
        ranB = new Random().nextInt(3);
//        int ranB = 0;
        count++;
        if (count == 10){
            hintlicznik = 1;
            hint_L.setText(Integer.toString(hintlicznik));
            hint_ = true;
        }
        if (ranB == 0) {
            String odp_1 = stolica.get(new Random().nextInt(wielkosc));
            String odp_2 = stolica.get(new Random().nextInt(wielkosc));
            odp1.setText(stolica.get(random));

            while (stolica.get(random) == odp_1) {
                odp_1 = stolica.get(new Random().nextInt(wielkosc));
            }
            odp2.setText(odp_1);
            while (stolica.get(random) == odp_2 && odp_1 == odp_2) {
                odp_2 = stolica.get(new Random().nextInt(wielkosc));

            }
            odp3.setText(odp_2);
        }

        if (ranB == 1){
            String odp_1 = stolica.get(new Random().nextInt(wielkosc));
            String odp_2 = stolica.get(new Random().nextInt(wielkosc));
            odp2.setText(stolica.get(random));

            while (stolica.get(random) == odp_1) {
                odp_1 = stolica.get(new Random().nextInt(wielkosc));
            }
            odp1.setText(odp_1);
            while (stolica.get(random) == odp_2 && odp_1 == odp_2) {
                odp_2 = stolica.get(new Random().nextInt(wielkosc));

            }
            odp3.setText(odp_2);
        }
        if (ranB == 2){
            String odp_1 = stolica.get(new Random().nextInt(wielkosc));
            String odp_2 = stolica.get(new Random().nextInt(wielkosc));
            odp3.setText(stolica.get(random));

            while (stolica.get(random) == odp_1) {
                odp_1 = stolica.get(new Random().nextInt(wielkosc));
            }
            odp2.setText(odp_1);
            while (stolica.get(random) == odp_2 && odp_1 == odp_2) {
                odp_2 = stolica.get(new Random().nextInt(wielkosc));

            }
            odp1.setText(odp_2);

        }
        tv.setText(kraj.get(random));


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        hint_L = findViewById(R.id.textView4);
        hint_L.setText(Integer.toString(hintlicznik));
        pointT = findViewById(R.id.textView2);
        pointT.setText("0");
        pointT.setTextColor(getColor(R.color.green));
        pointF = findViewById(R.id.textView5);
        pointF.setText("0");
        pointF.setTextColor(getColor(R.color.red));
        im = findViewById(R.id.imageView2);
        fab = findViewById(R.id.fab);
        odp1 = findViewById(R.id.button1);
        odp2 = findViewById(R.id.button2);
        odp3 = findViewById(R.id.button3);
        WczytajZmienne();
        ify();

            odp1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (odp1.getText().toString() == stolica.get(random)) {
                        ify();
                        count_t++;
                        pointT.setText(Integer.toString(count_t));
                    }else {
                        count_f++;
                        pointF.setText(Integer.toString(count_f));
                        tv.setBackgroundColor(getColor(R.color.red));
                        odp1.setBackgroundResource(R.drawable.button_red);

                    }

                }
            });


        odp2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (odp2.getText().toString() == stolica.get(random)) {

                        count_t++;
                        pointT.setText(Integer.toString(count_t));

                        ify();
                    }else {
                        count_f++;
                        pointF.setText(Integer.toString(count_f));
                        tv.setBackgroundColor(getColor(R.color.red));
                        odp2.setBackgroundResource(R.drawable.button_red);
                    }
                }
                });


            odp3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (odp3.getText().toString() == stolica.get(random)) {
                        ify();
                        count_t++;
                        pointT.setText(Integer.toString(count_t));
                    }else {
                        count_f++;
                        pointF.setText(Integer.toString(count_f));
                        tv.setBackgroundColor(getColor(R.color.red));
                        odp3.setBackgroundResource(R.drawable.button_red);

                    }
                }
            });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hint_) {
                    hint();
                    hint_ = false;
                    hintlicznik --;
                    hint_L.setText(Integer.toString(hintlicznik));
                }else {

                }
            }
        });
    }
}