package com.example.emi_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2, text3;
    TextView t1, t2, t3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> Calculate());

    }

    private void Calculate() {

        double amount = Double.parseDouble(text1.getText().toString());
        double interestRate = Double.parseDouble(text2.getText().toString());
        double tenure = Double.parseDouble(text3.getText().toString());

        interestRate = interestRate / (12 * 100); // one month interest
        tenure = tenure * 12; // one month period

        double emi = (amount * interestRate * (double) Math.pow(1 + interestRate, tenure))
                / (double) (Math.pow(1 + interestRate, tenure) - 1);


        t1.setText("Total EMI per month: $" + emi);

    }
}