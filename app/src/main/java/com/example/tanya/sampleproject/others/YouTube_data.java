package com.example.tanya.sampleproject.others;

import android.os.Parcel;
import android.os.Parcelable;

public class YouTube_data  implements Parcelable{
    String title;
    String URL;
    String author_name;

    public YouTube_data(String title, String URL, String author_name) {
        this.title = title;
        this.URL = URL;
        this.author_name = author_name;
    }

    protected YouTube_data(Parcel in) {
        title = in.readString();
        URL = in.readString();
        author_name = in.readString();
    }

    public static final Creator<YouTube_data> CREATOR = new Creator<YouTube_data>() {
        @Override
        public YouTube_data createFromParcel(Parcel in) {
            return new YouTube_data(in);
        }

        @Override
        public YouTube_data[] newArray(int size) {
            return new YouTube_data[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getURL() {
        return URL;
    }

    public String getAuthor_name() {
        return author_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(URL);
        parcel.writeString(author_name);
    }
}
