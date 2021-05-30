package com.geekbrains.lavsam.activity_lifecycle_2;

import android.os.Parcel;
import android.os.Parcelable;

public class Counter implements Parcelable {

    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter(in);
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };
    private int value;
    private int value2;

    public Counter(int value) {
        this.value = value;
    }

    protected Counter(Parcel in) {
        value = in.readInt();
        value2 = in.readInt();
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(value);
        dest.writeInt(value2);
    }
}
