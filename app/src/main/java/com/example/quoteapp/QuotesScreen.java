package com.example.quoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuotesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quotes_screen);

        String category = getIntent().getStringExtra("category");

        String[] quotes = new String[]{
                category + " Quote 1",
                category + " Quote 2",
                category + " Quote 3",
                category + " Quote 4",
                category + " Quote 5",
                category + " Quote 6",
        };


        ListView listView = findViewById(R.id.quoteList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1, quotes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent , View view , int  position , long id)->{
            Intent intent = new Intent(QuotesScreen.this , QuoteDetailsScreen.class);
            intent.putExtra("quote",quotes[position]);
            startActivity(intent);
        });



    }
}