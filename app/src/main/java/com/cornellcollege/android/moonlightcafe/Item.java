package com.cornellcollege.android.moonlightcafe;

import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
public class Item {

    private UUID mId;
    private String mName;
    private double mPrice;



    private int mLayoutResId;

    private Hashtable<String, Boolean> mOptions;

    public Item(String name) {
        this(UUID.randomUUID(), name);
    }

    public Item(UUID id, String name) {
        mId = id;
        mName = name;
    }
    public int getLayoutResId() {
        return mLayoutResId;
    }

    public void setLayoutResId(int mLayoutResId) {
        this.mLayoutResId = mLayoutResId;
    }

    public UUID getId() {
        return mId;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public Hashtable getOptions() {
        return mOptions;
    }

    public void setOptions(Hashtable<String, Boolean> options) {
        mOptions = options;
    }
}
