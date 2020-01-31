package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create ArrayList of Word colors
        ArrayList<Word> colorsList = new ArrayList<>();

        //add colors
        colorsList.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        colorsList.add(new Word("green","chokokki", R.drawable.color_green));
        colorsList.add(new Word("brown","ṭakaakki", R.drawable.color_brown));
        colorsList.add(new Word("gray","ṭopoppi", R.drawable.color_gray));
        colorsList.add(new Word("black","kululli", R.drawable.color_black));
        colorsList.add(new Word("white","kelelli", R.drawable.color_white));
        colorsList.add(new Word("dusty yellow","ṭopiisә", R.drawable.color_dusty_yellow));
        colorsList.add(new Word("mustard yellow","chiwiiṭә", R.drawable.color_mustard_yellow));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, colorsList, R.color.category_colors));


    }
}
