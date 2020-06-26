package com.gulsum.onal.Helper;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;

public class PostModel implements Parcelable
{

    String mainText,senderName,profileImage,title;
    Timestamp time;

    public PostModel() {
    }


    public PostModel(String mainText, String senderName, String profileImage, String title, Timestamp time) {
        this.mainText = mainText;
        this.senderName = senderName;
        this.profileImage = profileImage;
        this.title = title;
        this.time = time;
    }

    protected PostModel(Parcel in) {
        mainText = in.readString();
        senderName = in.readString();
        profileImage = in.readString();
        title = in.readString();
        time = in.readParcelable(Timestamp.class.getClassLoader());
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    public String getMainText() {
        return mainText;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mainText);
        dest.writeString(senderName);
        dest.writeString(profileImage);
        dest.writeString(title);
        dest.writeParcelable(time, flags);
    }
}

