package com.sedatyilmaz.sayfalar;


public class Urunler {
    private int _id;
    private String _urunAd;

    public Urunler(){

    }

    public Urunler(String urunAd) {
        this._urunAd = urunAd;
    }

    public int get_id() {
        return _id;
    }

    public String get_urunAd() {
        return _urunAd;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_urunAd(String _urunAd) {
        this._urunAd = _urunAd;
    }
}
