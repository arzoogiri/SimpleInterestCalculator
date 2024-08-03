package com.example.simpleinterest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editPrincipal, editRate, editTime;
    Button btnCalculate;
    TextView textViewResult;

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

        // Initialize the views
        editPrincipal = findViewById(R.id.principal);
        editRate = findViewById(R.id.rate);
        editTime = findViewById(R.id.time);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.result);

        // Set OnClickListener for the button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSimpleInterest();
            }
        });
    }

    private void calculateSimpleInterest() {
        // Get the input values
        String principalStr = editPrincipal.getText().toString();
        String rateStr = editRate.getText().toString();
        String timeStr = editTime.getText().toString();

        // Check if any input is empty
        if (principalStr.isEmpty() || rateStr.isEmpty() || timeStr.isEmpty()) {
            textViewResult.setText("Please enter all values.");
            return;
        }

        // Parse the input values to double
        double principal = Double.parseDouble(principalStr);
        double rate = Double.parseDouble(rateStr);
        double time = Double.parseDouble(timeStr);

        // Calculate the simple interest
        double interest = (principal * rate * time) / 100;

        // Display the result
        textViewResult.setText(String.valueOf(interest));
    }
}
