package com.example.scoremate;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class AtBat implements Serializable {
    //Lineup pos, Name, Position, status, runbool, basereached, balls, strikes
    private int lp;
    private String name;
    private String position;
    private String hstatus;
    private String mstatus;
    private boolean run;
    private int basereached;
    private int balls;
    private int strikes;

    private int runno;

    public AtBat(int lp, String name, String position, String hstatus, String mstatus, boolean run, int basereached,
                 int balls, int strikes, int runno) {
        this.lp = lp;
        this.name = name;
        this.position = position;
        this.hstatus = hstatus;
        this.mstatus = mstatus;
        this.run = run;
        this.basereached = basereached;
        this.balls = balls;
        this.strikes = strikes;
        this.runno = runno;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public int getBasereached() {
        return basereached;
    }

    public void setBasereached(int basereached) {
        this.basereached = basereached;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getRunno() {
        return runno;
    }

    public void setRunno(int runno) {
        this.runno = runno;
    /*
    public static final Parcelable.Creator<AtBat> CREATOR = new Parcelable.Creator<AtBat>() {
        @Override
        public AtBat createFromParcel(Parcel in) {
            return new AtBat(in);
        }

        @Override
        public AtBat[] newArray(int size) {
            return new AtBat[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }
    private AtBat(Parcel in) {
        // Read parcel data into class fields
    }
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    parcel.writeInt(lp);
    parcel.writeString(name);
    parcel.writeString(position);
    parcel.writeString(status);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeBoolean(run);
        }
        parcel.writeInt(basereached);
        parcel.writeInt(balls);
        parcel.writeInt(strikes);
        parcel.writeInt(runno);

    }
    */
    }

    public String getHstatus() {
        return hstatus;
    }

    public void setHstatus(String hstatus) {
        this.hstatus = hstatus;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }
}
