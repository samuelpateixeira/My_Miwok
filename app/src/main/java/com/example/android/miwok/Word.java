package com.example.android.miwok;

import android.graphics.Bitmap;

public class Word {

    // State
    private String mEnglishTranslation;
    private String mMiwokTranslation;
    private int mImageResource = 0;
    private boolean mHasImage = false;
    private int mSoundResourceId = -1;



    // Getters
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public int getImageResourceId() {
        return mImageResource;
    }
    public boolean hasImage() {
        return mHasImage;
    }
    public int getSoundResourceId() {
        return mSoundResourceId;
    }

    //constructors

    public Word(String englishTranslation, String miwokTranslation) {
        this.mEnglishTranslation = englishTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    public Word(String englishTranslation, String miwokTranslation, int imageResource) {
        this.mEnglishTranslation = englishTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResource = imageResource;
        this.mHasImage = true;
    }

    public Word(int soundResourceId, String englishTranslation, String miwokTranslation) {
        this.mEnglishTranslation = englishTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mSoundResourceId = soundResourceId;
    }

    public Word(int soundResourceId, String englishTranslation, String miwokTranslation, int imageResource) {
        this.mEnglishTranslation = englishTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResource = imageResource;
        this.mHasImage = true;
        this.mSoundResourceId = soundResourceId;
    }

}
