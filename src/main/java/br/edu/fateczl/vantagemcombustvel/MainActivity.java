/*
@author: Alvaro Dias
RA: 1110482223004
 */
package br.edu.fateczl.vantagemcombustvel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valorGasolina;
    private EditText valorEtanol;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        valorGasolina = findViewById(R.id.valorGasolina);
        valorGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        valorEtanol = findViewById(R.id.valorEtanol);
        valorEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes = findViewById(R.id.txtRes);
        txtRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());

    }
    public void calc(){
        double gasolina = Double.parseDouble(valorGasolina.getText().toString());
        double etanol = Double.parseDouble(valorEtanol.getText().toString());

        double percGas = (gasolina*0.70);

        String res;
        if (etanol < percGas){
            res = "O etanol é mais vantajoso que a gasolina";

        } else {
            res = "A gasolina é mais vantajosa que o etanol";

        }
        txtRes.setText(res);
        valorGasolina.setText("");
        valorEtanol.setText("");


    }
}