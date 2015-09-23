package com.cornellcollege.android.moonlightcafe;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends FragmentActivity
                        implements MenuListFragment.Callbacks{

    public int mPizzaQuan;
    public int mBurgerQuan;
    public int mFriesQuan;

    @Override
    protected Fragment createFragment() {
        return new MenuListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Receiving callbacks here
    }

    @Override
    public void onItemSelected(Item item) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = CustomizeActivity.newIntent(this, item.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CustomizeFragment.newInstance(item.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

}
