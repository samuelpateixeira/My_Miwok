package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WordsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private int requestAudioFocus() {
        return mAudioManager.requestAudioFocus(mFocusRequest);
    }

    private void abandonAudioFocusRequest() {
        mAudioManager.abandonAudioFocusRequest(mFocusRequest);
    }

    AudioAttributes mPlaybackAttributes = new AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
         .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
         .build();

    AudioFocusRequest mFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK)
            .setAudioAttributes(mPlaybackAttributes)
            .setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AudioManager.AUDIOFOCUS_GAIN:
                            mMediaPlayer.start();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            mMediaPlayer.stop();
                            releaseMediaPlayer();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                            break;
                    }
                }
            })
            .build();


    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            abandonAudioFocusRequest();
        }
    }

    MediaPlayer.OnCompletionListener donePlaying = mp -> {
        releaseMediaPlayer();
        //Toast.makeText(this, "released", Toast.LENGTH_LONG).show();
    };

    @Override
    protected void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        String type = getIntent().getStringExtra("type");

        int categoryColor = R.color.category_numbers;

        setTitle(type);

        //Audio Manager
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        //create ArrayList of Words
        ArrayList<Word> words = new ArrayList<>();

        switch (type) {
            case "Numbers":

                categoryColor = R.color.category_numbers;

                //region add numbers
                words.add(new Word(R.raw.number_one ,"one","lutti", R.drawable.number_one));
                words.add(new Word(R.raw.number_two ,"two","otiiko", R.drawable.number_two));
                words.add(new Word(R.raw.number_three ,"three","tolookosu", R.drawable.number_three));
                words.add(new Word(R.raw.number_four ,"four","oyyisa", R.drawable.number_four));
                words.add(new Word(R.raw.number_five ,"five","massokka", R.drawable.number_five));
                words.add(new Word(R.raw.number_six ,"six","temmokka", R.drawable.number_six));
                words.add(new Word(R.raw.number_seven ,"seven","tenekaku", R.drawable.number_seven));
                words.add(new Word(R.raw.number_eight ,"eight","kawinta", R.drawable.number_eight));
                words.add(new Word(R.raw.number_nine ,"nine","wo'e", R.drawable.number_nine));
                words.add(new Word(R.raw.number_ten ,"ten","na'aacha", R.drawable.number_ten));
                //endregion

                break;
            case "Family Members":

                categoryColor = R.color.category_family;

                //region add family members
                words.add(new Word(R.raw.family_father ,"father","әpә", R.drawable.family_father));
                words.add(new Word(R.raw.family_mother ,"mother","әṭa", R.drawable.family_mother));
                words.add(new Word(R.raw.family_son ,"son","angsi", R.drawable.family_son));
                words.add(new Word(R.raw.family_daughter ,"daughter","tune", R.drawable.family_daughter));
                words.add(new Word(R.raw.family_older_brother ,"older brother","taachi", R.drawable.family_older_brother));
                words.add(new Word(R.raw.family_younger_brother ,"younger brother","chalitti", R.drawable.family_younger_brother));
                words.add(new Word(R.raw.family_older_sister ,"older sister","teṭe", R.drawable.family_older_sister));
                words.add(new Word(R.raw.family_younger_sister ,"younger sister","kolliti", R.drawable.family_younger_sister));
                words.add(new Word(R.raw.family_grandmother ,"grandmother","ama", R.drawable.family_grandmother));
                words.add(new Word(R.raw.family_grandfather ,"grandfather","paapa", R.drawable.family_grandfather));
                //endregion

                break;
            case "Colors":

                categoryColor = R.color.category_colors;

                //region add colors
                words.add(new Word(R.raw.color_red ,"red","weṭeṭṭi", R.drawable.color_red));
                words.add(new Word(R.raw.color_green ,"green","chokokki", R.drawable.color_green));
                words.add(new Word(R.raw.color_brown ,"brown","ṭakaakki", R.drawable.color_brown));
                words.add(new Word(R.raw.color_gray ,"gray","ṭopoppi", R.drawable.color_gray));
                words.add(new Word(R.raw.color_black ,"black","kululli", R.drawable.color_black));
                words.add(new Word(R.raw.color_white ,"white","kelelli", R.drawable.color_white));
                words.add(new Word(R.raw.color_dusty_yellow ,"dusty yellow","ṭopiisә", R.drawable.color_dusty_yellow));
                words.add(new Word(R.raw.color_mustard_yellow ,"mustard yellow","chiwiiṭә", R.drawable.color_mustard_yellow));
                //endregion

                break;
            case "Phrases":

                categoryColor = R.color.category_phrases;

                //region add phrases
                words.add(new Word(R.raw.phrase_where_are_you_going ,"Where are you going?","minto wuksus"));
                words.add(new Word(R.raw.phrase_what_is_your_name ,"What is your name?","tinnә oyaase'nә"));
                words.add(new Word(R.raw.phrase_my_name_is ,"My name is...","oyaaset..."));
                words.add(new Word(R.raw.phrase_how_are_you_feeling ,"How are you feeling?","michәksәs?"));
                words.add(new Word(R.raw.phrase_im_feeling_good ,"I’m feeling good.","kuchi achit"));
                words.add(new Word(R.raw.phrase_are_you_coming ,"Are you coming?","әәnәs'aa?"));
                words.add(new Word(R.raw.phrase_yes_im_coming ,"Yes, I’m coming.","hәә’ әәnәm"));
                words.add(new Word(R.raw.phrase_im_coming ,"I’m coming.","әәnәm"));
                words.add(new Word(R.raw.phrase_lets_go ,"Let’s go.","yoowutis"));
                words.add(new Word(R.raw.phrase_come_here ,"Come here.","әnni'nem"));
                //endregion

                break;
            default:
                Toast.makeText(this, "not a valid category", Toast.LENGTH_LONG).show();
                break;
        }


        // Find the listView
        ListView listView = findViewById(R.id.list);
        // Set its adapter to be a new WordAdapter
        listView.setAdapter(new WordAdapter(this, words, categoryColor));

        //Set OnItemClickListener to play audio file
        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();
            Word currentWord = words.get(position);
            int requestSuccess = requestAudioFocus();
            if (requestSuccess == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mMediaPlayer = MediaPlayer.create(this, currentWord.getSoundResourceId());
                mMediaPlayer.setOnCompletionListener(donePlaying);
                mMediaPlayer.start();
            } else {
                Toast.makeText(this, "audio focus not granted", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
