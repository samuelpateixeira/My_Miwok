package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //create ArrayList of Word numbers
        ArrayList<Word> numbersList = new ArrayList<>();

        //add numbers
        numbersList.add(new Word("one","lutti"));
        numbersList.add(new Word("two","otiiko"));
        numbersList.add(new Word("three","tolookosu"));
        numbersList.add(new Word("four","oyyisa"));
        numbersList.add(new Word("five","massokka"));
        numbersList.add(new Word("six","temmokka"));
        numbersList.add(new Word("seven","tenekaku"));
        numbersList.add(new Word("eight","kawinta"));
        numbersList.add(new Word("nine","wo'e"));
        numbersList.add(new Word("ten","na'aacha"));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, numbersList));

    }

}
