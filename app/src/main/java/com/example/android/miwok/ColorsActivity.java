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
        colorsList.add(new Word("red","weṭeṭṭi"));
        colorsList.add(new Word("green","chokokki"));
        colorsList.add(new Word("brown","ṭakaakki"));
        colorsList.add(new Word("gray","ṭopoppi"));
        colorsList.add(new Word("black","kululli"));
        colorsList.add(new Word("white","kelelli"));
        colorsList.add(new Word("dusty yellow","ṭopiisә"));
        colorsList.add(new Word("mustard yellow","chiwiiṭә"));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, colorsList));


    }
}
