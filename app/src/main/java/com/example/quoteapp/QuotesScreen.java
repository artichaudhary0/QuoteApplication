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

import java.util.HashMap;

public class QuotesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quotes_screen);

        String category = getIntent().getStringExtra("category");

//        String[] quotes = new String[]{
//                category + " Quote 1",
//                category + " Quote 2",
//                category + " Quote 3",
//                category + " Quote 4",
//                category + " Quote 5",
//                category + " Quote 6",
//        };


        HashMap<String, String[]> quotesMap = new HashMap<>();


        quotesMap.put("Motivational", new String[]{
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Your time is limited, so don’t waste it living someone else’s life.",
                "Don’t watch the clock; do what it does. Keep going.",
                "The only way to achieve the impossible is to believe it is possible.",
                "It does not matter how slowly you go as long as you do not stop."
        });
        quotesMap.put("Happy", new String[]{
                "Happiness is the highest form of health.",
                "The purpose of our lives is to be happy.",
                "Happiness depends upon ourselves.",
                "Happiness is not by chance, but by choice.",
                "Enjoy the little things, for one day you may look back and realize they were the big things."
        });
        quotesMap.put("Love", new String[]{
                "Love recognizes no barriers. It jumps hurdles, leaps fences, penetrates walls to arrive at its destination full of hope.",
                "To love and be loved is to feel the sun from both sides.",
                "Love is when the other person's happiness is more important than your own.",
                "Being deeply loved by someone gives you strength, while loving someone deeply gives you courage.",
                "Love is composed of a single soul inhabiting two bodies."
        });
        quotesMap.put("Sad", new String[]{
                "Tears are words that need to be written.",
                "Although the world is full of suffering, it is also full of the overcoming of it.",
                "Sometimes we must experience darkness before we can truly appreciate the light.",
                "Don’t cry because it’s over, smile because it happened.",
                "Sadness flies away on the wings of time."
        });
        quotesMap.put("Hope", new String[]{
                "Once you choose hope, anything's possible.",
                "Hope is the only thing stronger than fear.",
                "Hope is being able to see that there is light despite all of the darkness.",
                "Shoot for the moon. Even if you miss, you’ll land among the stars.",
                "When the world says, ‘Give up,’ hope whispers, ‘Try one more time.’"
        });


        ListView listView = findViewById(R.id.quoteList);

        String[] quotes = quotesMap.getOrDefault(category,new String[]{"No Quotes are available."});

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quotes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Intent intent = new Intent(QuotesScreen.this, QuoteDetailsScreen.class);
            intent.putExtra("quote", quotes[position]);
            startActivity(intent);
        });


    }
}