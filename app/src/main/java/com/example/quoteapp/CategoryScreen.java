package com.example.quoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CategoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_screen);

        String[] categories = {"Motivational", "Happy", "Love", "Sad", "Hope"};

        ListView listView = findViewById(R.id.categoryList);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent , View view ,  int  position , long id)->{
            Intent intent = new Intent(CategoryScreen.this , QuotesScreen.class);
            intent.putExtra("category",categories[position]);
            startActivity(intent);
        });






    }
}