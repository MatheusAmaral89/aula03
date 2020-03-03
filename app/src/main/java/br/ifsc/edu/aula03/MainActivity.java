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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edPeso, edAltura;
    TextView tvIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPeso   = findViewById(R.id.edTextPeso);
        edAltura = findViewById(R.id.edTextAltura);
        tvIMC    = findViewById(R.id.txtIMC);

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

        tvIMC.setText(Double.toString(calculaIMC(peso,altura)));
    }
}
