package com.example.dictionaryapp;

import java.io.Serializable;

public class Kelimeler implements Serializable {

    private int kelime_id;
    private String turkce;
    private String ingilizce;

    public Kelimeler() {
    }

    public Kelimeler(int kelime_id, String kelime_turkish, String kelime_english) {
        this.kelime_id = kelime_id;
        this.turkce = kelime_turkish;
        this.ingilizce = kelime_english;
    }

    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }

    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        this.ingilizce = ingilizce;
    }
}
