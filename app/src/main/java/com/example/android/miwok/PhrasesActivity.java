package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create ArrayList of Word phrases
        ArrayList<Word> numbersList = new ArrayList<>();

        //add phrases
        numbersList.add(new Word("Where are you going?","minto wuksus"));
        numbersList.add(new Word("What is your name?","tinnә oyaase'nә"));
        numbersList.add(new Word("My name is...","oyaaset..."));
        numbersList.add(new Word("How are you feeling?","michәksәs?"));
        numbersList.add(new Word("I’m feeling good.","kuchi achit"));
        numbersList.add(new Word("Are you coming?","әәnәs'aa?"));
        numbersList.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        numbersList.add(new Word("I’m coming.","әәnәm"));
        numbersList.add(new Word("Let’s go.","yoowutis"));
        numbersList.add(new Word("Come here.","әnni'nem"));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, numbersList, R.color.category_phrases));


    }
}
