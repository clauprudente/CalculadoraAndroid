package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculoViagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_viagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtDistancia, edtPrecoCombustivel, edtMediaConsumo;
        Button btnCalcularViagem;
        TextView txtResultado;

        edtDistancia = findViewById(R.id.edtDistancia);
        edtPrecoCombustivel = findViewById(R.id.edtPrecoCombustivel);
        edtMediaConsumo = findViewById(R.id.edtMediaConsumo);
        btnCalcularViagem = findViewById(R.id.btnCalcularViagem);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcularViagem.setOnClickListener(v -> {
            double distancia = Double.parseDouble(edtDistancia.getText().toString());
            double precoCombustivel = Double.parseDouble(edtPrecoCombustivel.getText().toString());
            double mediaConsumo = Double.parseDouble(edtMediaConsumo.getText().toString());

            double litrosNecessarios = distancia / mediaConsumo;
            double custoTotal = litrosNecessarios * precoCombustivel;

            txtResultado.setText("Custo da viagem: R$ " + String.format("%.2f", custoTotal));

        });
    }}