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
        familyMembersList.add(new Word("father","әpә", R.drawable.family_father));
        familyMembersList.add(new Word("mother","әṭa", R.drawable.family_mother));
        familyMembersList.add(new Word("son","angsi", R.drawable.family_son));
        familyMembersList.add(new Word("daughter","tune", R.drawable.family_daughter));
        familyMembersList.add(new Word("older brother","taachi", R.drawable.family_older_brother));
        familyMembersList.add(new Word("younger brother","chalitti", R.drawable.family_younger_brother));
        familyMembersList.add(new Word("older sister","teṭe", R.drawable.family_older_sister));
        familyMembersList.add(new Word("younger sister","kolliti", R.drawable.family_younger_sister));
        familyMembersList.add(new Word("grandmother","ama", R.drawable.family_grandmother));
        familyMembersList.add(new Word("grandfather","paapa", R.drawable.family_grandfather));

        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, familyMembersList, R.color.category_family));


    }
}
