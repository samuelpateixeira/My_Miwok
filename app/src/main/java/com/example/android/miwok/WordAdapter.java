package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId = R.color.primary_dark_color;

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

        // Find the ImageView in the list_item.xml layout with the ID image_view
        ImageView imageView = wordView.findViewById(R.id.image_view);
        // Get the image from the currentWord object and
        // set this image on the image view
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
        } else { imageView.setVisibility(View.GONE); }

        //set color
        //View textViewGroup = wordView.findViewById(R.id.words_viewgroup);
        View parentView = wordView.findViewById(R.id.parent_view);
        //textViewGroup.setBackgroundColor(getContext().getResources().getColor(mColorResourceId));
        parentView.setBackgroundColor(getContext().getResources().getColor(mColorResourceId));

    /*    // Handle playing sound
        if (currentWord.getSoundResourceId() != -1) {
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentWord.getSoundResourceId());
            wordView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.start();
                    }
                }
            );
        }*/
        return wordView;

    }

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects, int colorResourceId) {
        super(context, R.layout.list_item, objects);
        this.mColorResourceId = colorResourceId;
    }
}

