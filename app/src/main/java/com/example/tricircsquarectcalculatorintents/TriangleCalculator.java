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

public class TriangleCalculator extends AppCompatActivity {

    //home button stuff
    Button btn_j_tri_returnHome;
    Intent homepage;

    //Triangle Declarations
    EditText et_j_heightTriangle;
    EditText et_j_baseTriangle;
    EditText et_j_sideB;
    EditText et_j_sideC;
    TextView tv_j_resultsTriangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_triangle_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Home Button
        btn_j_tri_returnHome = findViewById(R.id.btn_v_tri_returnHome);
        homepage = new Intent(TriangleCalculator.this, MainActivity.class);

        //Triangle
        et_j_heightTriangle = findViewById(R.id.et_v_heightTriangle);
        et_j_baseTriangle = findViewById(R.id.et_v_baseTriangle);
        et_j_sideB = findViewById(R.id.et_v_sideB);
        et_j_sideC = findViewById(R.id.et_v_sideC);
        tv_j_resultsTriangle = findViewById(R.id.tv_v_resultsTriangle);


        buttonClickGoHome();
        textChangeListenerTriangle();

    }
    public void buttonClickGoHome()
    {
        btn_j_tri_returnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(homepage);
            }
        });
    }
    public void setAreaPerimeterTriangle(String heightS, String baseS, String sideBS, String sideCS)
    {
        if (heightS.isEmpty() || baseS.isEmpty() || sideBS.isEmpty() || sideCS.isEmpty())
        {
            return;
        }

        double height = Double.parseDouble(heightS);
        double base = Double.parseDouble(baseS);
        double sideB = Double.parseDouble(sideBS);
        double sideC = Double.parseDouble(sideCS);

        double area = (base * height)/2;
        double perimeter = base + sideB + sideC;

        tv_j_resultsTriangle.setText("Area = " + area + "\nPerimeter = " + perimeter);
    }
    public void textChangeListenerTriangle()
    {
        et_j_heightTriangle.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setAreaPerimeterTriangle(et_j_heightTriangle.getText().toString(), et_j_baseTriangle.getText().toString(), et_j_sideB.getText().toString(), et_j_sideC.getText().toString());

            }
        });

        et_j_baseTriangle.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setAreaPerimeterTriangle(et_j_heightTriangle.getText().toString(), et_j_baseTriangle.getText().toString(), et_j_sideB.getText().toString(), et_j_sideC.getText().toString());

            }
        });

        et_j_sideB.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setAreaPerimeterTriangle(et_j_heightTriangle.getText().toString(), et_j_baseTriangle.getText().toString(), et_j_sideB.getText().toString(), et_j_sideC.getText().toString());

            }
        });

        et_j_sideC.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setAreaPerimeterTriangle(et_j_heightTriangle.getText().toString(), et_j_baseTriangle.getText().toString(), et_j_sideB.getText().toString(), et_j_sideC.getText().toString());

            }
        });
    }
}