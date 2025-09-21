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

public class RectangleCalculator extends AppCompatActivity {

    //home button stuff
    Button btn_j_rect_returnHome;
    Intent homepage;

    //Rectangle Declarations
    EditText et_j_length;
    EditText et_j_width;
    TextView tv_j_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rectangle_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //home button
        btn_j_rect_returnHome = findViewById(R.id.btn_v_rect_returnHome);
        homepage = new Intent(RectangleCalculator.this, MainActivity.class);

        //Rectangle
        et_j_length = findViewById(R.id.et_v_length);
        et_j_width = findViewById(R.id.et_v_width);
        tv_j_results = findViewById(R.id.tv_v_results);

        buttonClickGoHome();
        textChangeListenerRectangle();

    }
    public void buttonClickGoHome()
    {
        btn_j_rect_returnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(homepage);
            }
        });
    }
    public void setAreaAndPerimeterRectangle(String lengthS, String widthS)
    {
        if(lengthS.isEmpty() || widthS.isEmpty())
        {
            //if either is empty, it wont compute anything, so the app doesn't break
            return;
        }

        //converts the strings to a double
        double length = Double.parseDouble(lengthS);
        double width = Double.parseDouble(widthS);

        double area = length * width;
        double perimeter = length + length + width + width;

        tv_j_results.setText("Area = " + area + "\n Perimeter = " + perimeter);

    }
    public void textChangeListenerRectangle()
    {
        et_j_width.addTextChangedListener(new TextWatcher()
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

                setAreaAndPerimeterRectangle(et_j_length.getText().toString(), et_j_width.getText().toString());

            }
        });

        et_j_length.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setAreaAndPerimeterRectangle(et_j_length.getText().toString(), et_j_width.getText().toString());
            }
        });
    }
}