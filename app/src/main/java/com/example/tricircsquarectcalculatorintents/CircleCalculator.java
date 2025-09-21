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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CircleCalculator extends AppCompatActivity {

    //home button stuff
    Button btn_j_circ_returnHome;
    Intent homepage;

    //Circle Declarations
    EditText et_j_radius;
    TextView tv_j_areaPerimeterCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circle_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //home button
        btn_j_circ_returnHome = findViewById(R.id.btn_v_circ_returnHome);
        homepage = new Intent(CircleCalculator.this, MainActivity.class);

        //Circle
        et_j_radius = findViewById(R.id.et_v_radius);
        tv_j_areaPerimeterCircle = findViewById(R.id.tv_v_computedAreaPerimeterCircle);

        buttonClickGoHome();
        textChangeListenerCircle();

    }
    public void buttonClickGoHome()
    {
        btn_j_circ_returnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(homepage);
            }
        });
    }
    public void setAreaPerimeterCircle(String radiusS)
    {
        if(radiusS.isEmpty())
        {
            return;
        }

        double radius = Double.parseDouble(radiusS);
        double pi = Math.PI;

        double area = pi * Math.pow(radius, 2);
        double perimeter = 2 * pi * radius;

        tv_j_areaPerimeterCircle.setText("Area = " + area + "\nPerimeter = " + perimeter);

    }
    public void textChangeListenerCircle()
    {
        et_j_radius.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void afterTextChanged(Editable s)
            {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                setAreaPerimeterCircle(et_j_radius.getText().toString());

            }
        });
    }
}