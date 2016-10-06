package com.cornellcollege.android.moonlightcafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 *Activity used to host food customization fragment
 */
public class CustomizeActivity extends FragmentActivity {

    public static final String EXTRA_ITEM_ID =
            "com.tibuchuba.android.moonlightcafe.item.id";


    public static Intent newIntent(Context packageContext, UUID itemId) {
        Intent intent = new Intent(packageContext, CustomizeActivity.class);
        intent.putExtra(EXTRA_ITEM_ID, itemId);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

        @Override
    protected Fragment createFragment() {
            UUID itemId = (UUID) getIntent().getSerializableExtra(EXTRA_ITEM_ID);
            return new CustomizeFragment().newInstance(itemId);
    }
}
