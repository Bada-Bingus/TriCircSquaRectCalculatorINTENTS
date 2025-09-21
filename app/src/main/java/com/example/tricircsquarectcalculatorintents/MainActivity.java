package com.example.tricircsquarectcalculatorintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //The Spinner
    ArrayAdapter<String> spinnerAdapter;
    Spinner sp_j_shapes;

    Intent rectanglecalc;
    Intent squarecalc;
    Intent circlecalc;
    Intent trianglecalc;

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

        sp_j_shapes = findViewById(R.id.sp_v_shapes);

        // We will use this to populate our spinner
        String[] shapes = new String[]{"Choose Shape", "Square", "Rectangle", "Circle", "Triangle"};

        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,shapes);

        sp_j_shapes.setAdapter(spinnerAdapter);

        rectanglecalc = new Intent(MainActivity.this,RectangleCalculator.class);
        squarecalc = new Intent(MainActivity.this, SquareCalculator.class);
        circlecalc = new Intent(MainActivity.this, CircleCalculator.class);
        trianglecalc = new Intent(MainActivity.this, TriangleCalculator.class);

        setupSpinnerChangeListener();

    }

    public void setupSpinnerChangeListener()
    {
        sp_j_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 0-3 Indexes (square, rectangle, circle, triangle)
                //square and rectangle will be mostly the same
                if(position == 0) //none
                {

                    //jack squat

                }
                else if(position == 1) //square
                {

                    startActivity(squarecalc);

                }
                else if(position == 2) //rectangle
                {

                    startActivity(rectanglecalc);

                }
                else if(position == 3) //circle
                {

                    startActivity(circlecalc);

                }
                else if(position == 4) //triangle
                {

                    startActivity(trianglecalc);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}