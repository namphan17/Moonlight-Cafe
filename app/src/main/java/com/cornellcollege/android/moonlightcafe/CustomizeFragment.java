package com.cornellcollege.android.moonlightcafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
public class CustomizeFragment extends Fragment{

    private static final String ARG_ITEM_ID = "item_id";

    private Item mItem;
    private int mQuantity = 0;
    private Button mAddButtonView;
    private Button mSubtractButtonView;
    private Button mOrderButtonView;

    private TextView mNameTextView;
    private TextView mQuantityTextView;

    private int mLayoutResId;

    private CheckBox mOption1;
    private CheckBox mOption2;
    private CheckBox mOption3;
    private CheckBox mOption4;
    private CheckBox mOption5;
    private CheckBox mOption6;
    private CheckBox mOption7;
    private CheckBox mOption8;
    private CheckBox mOption9;




    public static CustomizeFragment newInstance(UUID itemId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_ID, itemId);

        CustomizeFragment fragment = new CustomizeFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    // Override onAttach and cast Callbacks to the Activity
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        mCallbacks = (Callbacks)activity;
//    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID) getArguments().getSerializable(ARG_ITEM_ID);
        setRetainInstance(true);            // Doesn't work
        mItem = ItemLab.get(getActivity()).getItem(itemId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mLayoutResId = mItem.getLayoutResId();
        View view = inflater.inflate(mLayoutResId, container, false);
        // Pizza layout
        if (mLayoutResId == R.layout.customize_pizza_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.pizza_item_name_text_view);
            mAddButtonView = (Button) view.findViewById(R.id.pizza_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.pizza_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.pizza_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.pizza_order_button);



            // Handle the options
            mOption1 = (CheckBox) view.findViewById(R.id.pizza_pepperoni);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("pepperoni", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.pizza_bacon);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("bacon", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.pizza_onion);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("onion", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.pizza_black_olives);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("black_olives", true);
                }
            });

            mOption5 = (CheckBox) view.findViewById(R.id.pizza_sausage);
            mOption5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("sausage", true);
                }
            });

            mOption6 = (CheckBox) view.findViewById(R.id.pizza_mushroom);
            mOption6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("mushroom", true);
                }
            });

            mOption7 = (CheckBox) view.findViewById(R.id.pizza_extracheese);
            mOption7.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("extra_cheese", true);
                }
            });

            mOption8 = (CheckBox) view.findViewById(R.id.pizza_chicken);
            mOption8.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("chicken", true);
                }
            });

            mOption9 = (CheckBox) view.findViewById(R.id.pizza_pineapple);
            mOption9.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("pineapple", true);
                }
            });
        }

        // Burger layout
        if (mLayoutResId == R.layout.customize_burger_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.burger_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.burger_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.burger_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.burger_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.burger_order_button);
            mOption1 = (CheckBox) view.findViewById(R.id.pizza_pepperoni);

            mOption1 = (CheckBox) view.findViewById(R.id.burger_lettuce);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("lettuce", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.burger_pickles);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("pickles", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.burger_onion);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("onion", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.burger_tomatoes);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("tomatoes", true);
                }
            });

            mOption5 = (CheckBox) view.findViewById(R.id.burger_cucumber);
            mOption5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("cucumber", true);
                }
            });

            mOption6 = (CheckBox) view.findViewById(R.id.burger_cheese);
            mOption6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("cheese", true);
                }
            });

            mOption7 = (CheckBox) view.findViewById(R.id.burger_bacon);
            mOption7.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("bacon", true);
                }
            });
        }

        // Chicken tender layout
        if (mLayoutResId == R.layout.customize_chicken_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.chicken_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.chicken_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.chicken_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.chicken_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.chicken_order_button);
            mOption1 = (CheckBox) view.findViewById(R.id.pizza_pepperoni);

            mOption1 = (CheckBox) view.findViewById(R.id.chicken_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("barbeque", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.chicken_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("hot", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.chicken_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ranch", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.chicken_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ketchup", true);
                }
            });
        }

        // Fries layout
        if (mLayoutResId == R.layout.customize_fries_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.fries_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.fries_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.fries_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.fries_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.fries_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.fries_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("barbeque", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.fries_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("hot", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.fries_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ranch", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.fries_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ketchup", true);
                }
            });
        }

        // Eggroll layout
        if (mLayoutResId == R.layout.customize_porkeggroll_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.eggroll_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.eggroll_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.eggroll_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.eggroll_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.eggroll_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.eggroll_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("barbeque", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.eggroll_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("hot", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.eggroll_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ranch", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.eggroll_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ketchup", true);
                }
            });
        }

        // Vegie eggroll layout
        if (mLayoutResId == R.layout.customize_vegie_eggroll_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.eggroll_vegie_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.eggroll_vegie_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.eggroll_vegie_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.eggroll_vegie_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.eggroll_vegie_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.eggroll_vegie_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("barbeque", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.eggroll_vegie_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("hot", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.eggroll_vegie_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ranch", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.eggroll_vegie_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("ketchup", true);
                }
            });
        }

        // Grilled cheese
        if (mLayoutResId == R.layout.customize_grilledcheese_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.grilled_cheese_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.grilled_cheese_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.grilled_cheese_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.grilled_cheese_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.grilled_cheese_order_button);
        }

        // Smoothie
        if (mLayoutResId == R.layout.customize_smoothie_fragment) {
//            mQuantity = 0;
            mNameTextView = (TextView) view.findViewById(R.id.pizza_item_name_text_view);
            mAddButtonView = (Button) view.findViewById(R.id.pizza_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.pizza_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.pizza_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.smoothie_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.smoothie_strawberry);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("strawberry", true);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.smoothie_pineapple);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("pineapple", true);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.smoothie_banana);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("banana", true);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.smoothie_forbidden_fruit);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("forbidden_fruit", true);
                }
            });

            mOption5 = (CheckBox) view.findViewById(R.id.smoothie_mango);
            mOption5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("mango", true);
                }
            });

            mOption6 = (CheckBox) view.findViewById(R.id.smoothie_lemonade);
            mOption6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.getOptions().put("lemonade", true);
                }
            });

        }


        mNameTextView.setText(mItem.getName());

        mAddButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuantity++;
                mQuantityTextView.setText("" + mQuantity);
            }
        });

        mSubtractButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuantity > 0) {
                    mQuantity--;
                    mQuantityTextView.setText("" + mQuantity);
                }
            }
        });

        mOrderButtonView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Do stuffs here
                Intent intent = SummaryActivity.newIntent(getActivity(), mItem.getId(), mQuantity);
                startActivity(intent);
            }
        });

        mQuantityTextView.setText("" + mQuantity);

        return view;
    }
}
