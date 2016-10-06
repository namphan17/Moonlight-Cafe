package com.cornellcollege.android.moonlightcafe;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 *This activity is for the order summary
 * @author Akash Surti, Hwi Ram Jeong, Nam Phan, Dawit Tsigie
 * @version 9/22/2015
 */
public class SummaryActivity extends FragmentActivity
                            implements SummaryFragment.Callbacks {

    public static final String SUMMARY_EXTRA_ITEM_ID =
            "Summary_Activity_Item_ID";
    public static final String ITEM_QUANTITY =
            "Item_Quantity";

    public static Intent newIntent(Context packageContext, UUID itemId, int mQuantity) {
        Intent intent = new Intent(packageContext, SummaryActivity.class);
        intent.putExtra(SUMMARY_EXTRA_ITEM_ID, itemId);
        intent.putExtra(ITEM_QUANTITY, mQuantity);
        return intent;
    }
    @Override
    public void order(Context context) {
        Intent intent = MenuActivity.newIntent(this, true);
        startActivity(intent);
    }

    @Override
    protected Fragment createFragment() {
        int mQuantity = getIntent().getIntExtra(ITEM_QUANTITY, 0);
        UUID mItemId = (UUID) getIntent().getSerializableExtra(SUMMARY_EXTRA_ITEM_ID);
        Fragment fragment = SummaryFragment.newInstance(mItemId, mQuantity);
        return fragment;
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }
}
