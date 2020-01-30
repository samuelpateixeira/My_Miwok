package com.example.android.miwok;

public class Word {

    // State
    private String mEnglishTranslation;
    private String mMiwokTranslation;

    // Methods
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public Word(String englishTranslation, String miwokTranslation) {
        this.mEnglishTranslation = englishTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }
}
