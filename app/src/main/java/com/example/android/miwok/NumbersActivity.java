package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create ArrayList of Word numbers
        ArrayList<Word> numbersList = new ArrayList<>();

        //add numbers
        numbersList.add(new Word(R.raw.sound ,"one","lutti", R.drawable.number_one));
        numbersList.add(new Word("two","otiiko", R.drawable.number_two));
        numbersList.add(new Word("three","tolookosu", R.drawable.number_three));
        numbersList.add(new Word("four","oyyisa", R.drawable.number_four));
        numbersList.add(new Word("five","massokka", R.drawable.number_five));
        numbersList.add(new Word("six","temmokka", R.drawable.number_six));
        numbersList.add(new Word("seven","tenekaku", R.drawable.number_seven));
        numbersList.add(new Word("eight","kawinta", R.drawable.number_eight));
        numbersList.add(new Word("nine","wo'e", R.drawable.number_nine));
        numbersList.add(new Word("ten","na'aacha", R.drawable.number_ten));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, numbersList, R.color.category_numbers));
    }

}
