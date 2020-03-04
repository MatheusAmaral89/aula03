package br.ifsc.edu.aula03;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edPeso, edAltura;
    TextView tvIMC;
    ImageView img;
    SeekBar sk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPeso   = findViewById(R.id.edTextPeso);
        edAltura = findViewById(R.id.edTextAltura);
        tvIMC    = findViewById(R.id.txtIMC);
        img      = findViewById(R.id.img);
        sk       = findViewById(R.id.seekBar);

    }

    public double calculaIMC(double prPeso, double prAltura){
        if (prAltura != 0){
            return prPeso / (prAltura * prAltura);
        }
        return 0;
    }

    public void IMC(View view) {
        double peso   = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());
        DecimalFormat f = new DecimalFormat("#.##");

        double imc = calculaIMC(peso,altura);

        if (imc < 17){
            img.setImageResource(R.drawable.mtabaixopeso);
        } else if (imc < 18.5){
            img.setImageResource(R.drawable.abaixopeso);
        } else if (imc < 25){
            img.setImageResource(R.drawable.pesonormal);
        } else if (imc < 30){
            img.setImageResource(R.drawable.acimapeso);
        }else if (imc < 35){
            img.setImageResource(R.drawable.obs1);
        }else if(imc < 40){
            img.setImageResource(R.drawable.obsd2);
        } else{
            img.setImageResource(R.drawable.obsd3);
        }

        tvIMC.setText(f.format(imc));
        sk.setProgress((int) imc);


    }
}
