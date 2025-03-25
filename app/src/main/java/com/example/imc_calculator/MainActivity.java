package com.example.imc_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    EditText txtWeight, txtLength;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txt_result);
        txtWeight = findViewById(R.id.weight);
        txtLength = findViewById(R.id.length_decimal);
        btnClick = findViewById(R.id.btnCalculator);

        btnClick.setOnClickListener(v -> {
            calcularIMC();
        });
    }

    private void calcularIMC() {
        String weightText = txtWeight.getText().toString();
        String heightText = txtLength.getText().toString();

        if (weightText.isEmpty() || heightText.isEmpty()) {
            txtMsg.setText("Preencha todos os campos!");
            return;
        }

        try {
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText);

            if (height <= 0) {
                txtMsg.setText("Altura deve ser maior que zero!");
                return;
            }

            double imc = weight / (height * height);
            txtMsg.setText(String.format("Seu IMC é: %.2f", imc));


        } catch (NumberFormatException e) {
            txtMsg.setText("Digite valores válidos!");
        }
    }
}
