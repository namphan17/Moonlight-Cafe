package com.cornellcollege.android.moonlightcafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Fragment used to display a list of menu items which are selectable
 */
public class MenuListFragment extends Fragment {

    private Callbacks mCallbacks;

    private Button mPizzaButtonView;
    private Button mBurgerButtonView;
    private Button mChickenTenderButtonView;
    private Button mFriesButtonView;
    private Button mEggRollButtonView;
    private Button mEggRollVegieButtonView;
    private Button mGrilledCheeseButtonView;
    private Button mSmoothieButtonView;
    /**
     * Require interface for hosting activities
     */
    public interface Callbacks {
        void onItemSelected(Item item);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (Callbacks) activity;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        mPizzaButtonView = (Button) view.findViewById(R.id.pizza_button_view);
        mPizzaButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Pizza"));
            }
        });

        mBurgerButtonView = (Button) view.findViewById(R.id.burger_button_view);
        mBurgerButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Burger"));
            }
        });

        mChickenTenderButtonView = (Button) view.findViewById(R.id.chicken_tender_button_view);
        mChickenTenderButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Chicken Tender"));
            }
        });

        mFriesButtonView = (Button) view.findViewById(R.id.fries_button_view);
        mFriesButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Fries"));
            }
        });

        mEggRollButtonView = (Button) view.findViewById(R.id.eggroll_button_view);
        mEggRollButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Eggroll(Pork)"));
            }
        });

        mEggRollVegieButtonView = (Button) view.findViewById(R.id.eggroll_vegie_button_view);
        mEggRollVegieButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Eggroll(Vegie)"));
            }
        });

        mGrilledCheeseButtonView = (Button) view.findViewById(R.id.grilled_cheese_button_view);
        mGrilledCheeseButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Grilled Cheese"));
            }
        });

        mSmoothieButtonView = (Button) view.findViewById(R.id.smoothie_button_view);
        mSmoothieButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.onItemSelected(ItemLab.get(getActivity()).getItem("Smoothie"));
            }
        });


        return view;
    }
}
