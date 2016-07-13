package com.demo.SearchFilter.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FiterBean implements Parcelable {
    private String fiterName;//筛选名字


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fiterName);
    }

    public FiterBean() {
    }

    private FiterBean(Parcel in) {
        this.fiterName = in.readString();
    }

    public static final Parcelable.Creator<FiterBean> CREATOR = new Parcelable.Creator<FiterBean>() {
        public FiterBean createFromParcel(Parcel source) {
            return new FiterBean(source);
        }

        public FiterBean[] newArray(int size) {
            return new FiterBean[size];
        }
    };

    public String getFiterName() {
        return fiterName;
    }

    public void setFiterName(String fiterName) {
        this.fiterName = fiterName;
    }


}
