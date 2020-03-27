/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Create intent
        Intent wordsActivityIntent = new Intent(context, WordsActivity.class);

        // Numbers


        // Find the View that shows the numbers category
        TextView numbers = findViewById(R.id.numbers);
        // Setting the click listener on the numbers view
        numbers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wordsActivityIntent.putExtra("type", "Numbers");
                startActivity(wordsActivityIntent);
            }
        });

        // Family
        // Find the View that shows the family members category
        TextView familyMembers = findViewById(R.id.family);
        // Setting the click listener on the numbers view
        familyMembers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wordsActivityIntent.putExtra("type", "Family Members");
                startActivity(wordsActivityIntent);
            }
        });

        // Colors
        // Find the View that shows the colors category
        TextView colors = findViewById(R.id.colors);
        // Setting the click listener on the numbers view
        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wordsActivityIntent.putExtra("type", "Colors");
                startActivity(wordsActivityIntent);
            }
        });

        // Phrases
        // Find the View that shows the phrases category
        TextView phrases = findViewById(R.id.phrases);
        // Setting the click listener on the numbers view
        phrases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wordsActivityIntent.putExtra("type", "Phrases");
                startActivity(wordsActivityIntent);
            }
        });

        TextView text = new TextView(this);
        LinearLayout root = findViewById(R.id.root);
        root.addView(text);

        Log.v("MainActivity", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MainActivity", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "onDestroy");
    }
}

