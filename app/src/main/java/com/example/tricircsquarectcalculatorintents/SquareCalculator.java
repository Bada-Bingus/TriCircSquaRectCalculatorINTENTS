package com.example.tricircsquarectcalculatorintents;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SquareCalculator extends AppCompatActivity {

    //home button stuff
    Button btn_j_sqr_returnHome;
    Intent homepage;

    //Square Declarations
    EditText et_j_length;
    TextView tv_j_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_square_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //home button
        btn_j_sqr_returnHome = findViewById(R.id.btn_v_sqr_returnHome);
        homepage = new Intent(SquareCalculator.this, MainActivity.class);

        //Square
        et_j_length = findViewById(R.id.et_v_length);
        tv_j_results = findViewById(R.id.tv_v_results);

        buttonClickGoHome();
        textChangeListenerSquare();

    }

    public void setAreaAndPerimeterSquare(String lengthS)
    {
        if(lengthS.isEmpty())
        {
            //if either is empty, it wont compute anything, so the app doesn't break
            return;
        }

        //converts the strings to a double
        double length = Double.parseDouble(lengthS);

        double area = Math.pow(length, 2);
        double perimeter = length*4;

        tv_j_results.setText("Area = " + area + "\n Perimeter = " + perimeter);

    }

    public void buttonClickGoHome()
    {
        btn_j_sqr_returnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(homepage);
            }
        });
    }

    public void textChangeListenerSquare()
    {

        et_j_length.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setAreaAndPerimeterSquare(et_j_length.getText().toString());
            }
        });
    }
}