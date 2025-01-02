package com.example.quoteapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class QuoteDetailsScreen extends AppCompatActivity {
    private TextView quoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quote_details_screen);

        quoteText = findViewById(R.id.quoteText);

        String quote = getIntent().getStringExtra("quote");
        quoteText.setText(quote);

        Button changebackground = findViewById(R.id.changeBackgroundButton);


        changebackground.setOnClickListener(this::changeBackground);
    }

    private void changeBackground(View view) {
        int[] colors = {Color.RED,Color.BLUE , Color.GREEN , Color.GRAY,Color.YELLOW};
        Random random = new Random();
        view.getRootView().setBackgroundColor(colors[random.nextInt(colors.length)]);
    }

}