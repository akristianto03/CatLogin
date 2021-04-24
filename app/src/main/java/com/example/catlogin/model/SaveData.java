package com.example.catlogin.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SaveData implements Parcelable {

    public static ArrayList<Account> savelist = new ArrayList<>();


    protected SaveData(Parcel in) {
    }

    public SaveData(String name, String email, String pass) {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SaveData> CREATOR = new Creator<SaveData>() {
        @Override
        public SaveData createFromParcel(Parcel in) {
            return new SaveData(in);
        }

        @Override
        public SaveData[] newArray(int size) {
            return new SaveData[size];
        }
    };
}
