package com.example.catlogin.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

    private String name,email,pass;

    public Account(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    protected Account(Parcel in) {
        name = in.readString();
        email = in.readString();
        pass = in.readString();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(pass);
    }
}
