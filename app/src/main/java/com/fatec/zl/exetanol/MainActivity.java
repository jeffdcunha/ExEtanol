package com.fatec.zl.exetanol;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 *@author:Jefferson Dantas da Cunha
 *@RA: 1110482323044
 */
public class MainActivity extends AppCompatActivity {

    private EditText etValorEtanol;
    private EditText etValorGasolina;
    private TextView tvRes;

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

        etValorEtanol = findViewById(R.id.etValorEtanol);
        etValorEtanol.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etValorGasolina = findViewById(R.id.etValorGasolina);
        etValorGasolina.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> Calcular());
    }

    private void Calcular(){
        float valorEtanol = Float.parseFloat(etValorEtanol.getText().toString());
        float valorGasolina = Float.parseFloat(etValorGasolina.getText().toString());
        float f = (valorGasolina * 0.7f);
        if(valorEtanol < f)
            tvRes.setText(R.string.s_mensagem_etanol);
        else
            tvRes.setText(R.string.s_mensagem_gasolina);
    }
}