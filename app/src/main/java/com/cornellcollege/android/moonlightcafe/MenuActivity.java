package com.cornellcollege.android.moonlightcafe;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 *This activity is for displaying the menus
 * @author Akash Surti, Hwi Ram Jeong, Nam Phan, Dawit Tsigie
 * @version 9/22/2015
 */

/**
 * Activity used to host MenuListFragment
 */
public class MenuActivity extends FragmentActivity
                        implements MenuListFragment.Callbacks {

    public int mPizzaQuan;
    public int mBurgerQuan;
    public int mFriesQuan;

    public static final String ORDER =
            "tibuchuba.ordered";

    @Override
    protected Fragment createFragment() {
        return new MenuListFragment();
    }


    public static Intent newIntent(Context context, boolean ordered) {
        Intent intent = new Intent(context, MenuActivity.class);
        intent.putExtra(ORDER, ordered);
        return intent;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean ordered = getIntent().getBooleanExtra(ORDER, false);
        if (ordered) {

            Toast.makeText(MenuActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
        }
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
