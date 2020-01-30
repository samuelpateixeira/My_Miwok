package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View wordView = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (wordView == null) {
            wordView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_view
        TextView miwokText = wordView.findViewById(R.id.miwok_view);
        // Get the Miwok text from the currentWord object and
        // set this text on the miwokText TextView
        miwokText.setText(currentWord.getMiwokTranslation());


        // Find the TextView in the list_item.xml layout with the ID english_view
        TextView englishText = wordView.findViewById(R.id.english_view);
        // Get the English text from the currentWord object and
        // set this text on the englishText TextView
        englishText.setText(currentWord.getEnglishTranslation());

        return wordView;
    }

    public WordAdapter(@NonNull Context context, @NonNull Word[] objects) {
        super(context, R.layout.list_item, objects);
    }

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects) {
        super(context,0, objects);
    }
}

