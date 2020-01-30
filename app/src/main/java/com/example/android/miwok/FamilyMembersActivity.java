package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create ArrayList of Word family members
        ArrayList<Word> familyMembersList = new ArrayList<>();

        //add family members
        familyMembersList.add(new Word("father","әpә"));
        familyMembersList.add(new Word("mother","әṭa"));
        familyMembersList.add(new Word("son","angsi"));
        familyMembersList.add(new Word("daughter","tune"));
        familyMembersList.add(new Word("older brother","taachi"));
        familyMembersList.add(new Word("younger brother","chalitti"));
        familyMembersList.add(new Word("older sister","teṭe"));
        familyMembersList.add(new Word("younger sister","kolliti"));
        familyMembersList.add(new Word("grandmother","ama"));
        familyMembersList.add(new Word("grandfather","paapa"));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, familyMembersList));


    }
}
