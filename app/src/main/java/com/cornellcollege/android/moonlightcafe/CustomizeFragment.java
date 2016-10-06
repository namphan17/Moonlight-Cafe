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

import java.util.Hashtable;
import java.util.UUID;

/**
 * Fragment used to layout and choose various optional add-ons for a food item
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
            Hashtable pizzaOptions = mItem.getOptions();
            pizzaOptions.put("pepperoni", false);
            pizzaOptions.put("bacon", false);
            pizzaOptions.put("onion", false);
            pizzaOptions.put("black_olives", false);
            pizzaOptions.put("sausage", false);
            pizzaOptions.put("mushroom", false);
            pizzaOptions.put("extra_cheese", false);
            pizzaOptions.put("chicken", false);
            pizzaOptions.put("pineapple", false);
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
                    boolean checked = (Boolean) mItem.getOptions().get("pepperoni");
                    mItem.getOptions().put("pepperoni", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.pizza_bacon);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("bacon");
                    mItem.getOptions().put("bacon", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.pizza_onion);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("onion");
                    mItem.getOptions().put("onion", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.pizza_black_olives);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("black_olives");
                    mItem.getOptions().put("black_olives", !checked);
                }
            });

            mOption5 = (CheckBox) view.findViewById(R.id.pizza_sausage);
            mOption5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("sausage");
                    mItem.getOptions().put("sausage", !checked);
                }
            });

            mOption6 = (CheckBox) view.findViewById(R.id.pizza_mushroom);
            mOption6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("mushroom");
                    mItem.getOptions().put("mushroom", !checked);
                }
            });

            mOption7 = (CheckBox) view.findViewById(R.id.pizza_extracheese);
            mOption7.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("extra_cheese");
                    mItem.getOptions().put("extra_cheese", !checked);
                }
            });

            mOption8 = (CheckBox) view.findViewById(R.id.pizza_chicken);
            mOption8.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("chicken");
                    mItem.getOptions().put("chicken", !checked);
                }
            });

            mOption9 = (CheckBox) view.findViewById(R.id.pizza_pineapple);
            mOption9.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("pineapple");
                    mItem.getOptions().put("pineapple", checked);
                }
            });
        }

        // Burger layout
        if (mLayoutResId == R.layout.customize_burger_fragment) {
//            mQuantity = 0;
            Hashtable burgerOptions = mItem.getOptions();
            burgerOptions.put("lettuce", false);
            burgerOptions.put("pickles", false);
            burgerOptions.put("onion", false);
            burgerOptions.put("tomatoes", false);
            burgerOptions.put("cucumber", false);
            burgerOptions.put("cheese", false);
            burgerOptions.put("bacon", false);
            mNameTextView = (TextView) view.findViewById(R.id.burger_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.burger_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.burger_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.burger_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.burger_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.burger_lettuce);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("lettuce");
                    mItem.getOptions().put("lettuce", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.burger_pickles);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("pickles");
                    mItem.getOptions().put("pickles", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.burger_onion);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("onion");
                    mItem.getOptions().put("onion", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.burger_tomatoes);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("tomatoes");
                    mItem.getOptions().put("tomatoes", !checked);
                }
            });

            mOption5 = (CheckBox) view.findViewById(R.id.burger_cucumber);
            mOption5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("cucumber");
                    mItem.getOptions().put("cucumber", !checked);
                }
            });

            mOption6 = (CheckBox) view.findViewById(R.id.burger_cheese);
            mOption6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("cheese");
                    mItem.getOptions().put("cheese", !checked);
                }
            });

            mOption7 = (CheckBox) view.findViewById(R.id.burger_bacon);
            mOption7.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("bacon");
                    mItem.getOptions().put("bacon", !checked);
                }
            });
        }

        // Chicken tender layout
        if (mLayoutResId == R.layout.customize_chicken_fragment) {
//            mQuantity = 0;
            Hashtable sauceOptions = mItem.getOptions();
            sauceOptions.put("barbeque", false);
            sauceOptions.put("hot", false);
            sauceOptions.put("ranch", false);
            sauceOptions.put("ketchup", false);
            mNameTextView = (TextView) view.findViewById(R.id.chicken_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.chicken_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.chicken_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.chicken_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.chicken_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.chicken_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("barbeque");
                    mItem.getOptions().put("barbeque", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.chicken_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("hot");
                    mItem.getOptions().put("hot", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.chicken_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ranch");
                    mItem.getOptions().put("ranch", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.chicken_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ketchup");
                    mItem.getOptions().put("ketchup", !checked);
                }
            });
        }

        // Fries layout
        if (mLayoutResId == R.layout.customize_fries_fragment) {
//            mQuantity = 0;
            Hashtable sauceOptions = mItem.getOptions();
            sauceOptions.put("barbeque", false);
            sauceOptions.put("hot", false);
            sauceOptions.put("ranch", false);
            sauceOptions.put("ketchup", false);
            mNameTextView = (TextView) view.findViewById(R.id.fries_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.fries_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.fries_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.fries_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.fries_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.fries_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("barbeque");
                    mItem.getOptions().put("barbeque", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.fries_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("hot");
                    mItem.getOptions().put("hot", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.fries_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ranch");
                    mItem.getOptions().put("ranch", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.fries_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ketchup");
                    mItem.getOptions().put("ketchup", !checked);
                }
            });
        }

        // Eggroll layout
        if (mLayoutResId == R.layout.customize_porkeggroll_fragment) {
//            mQuantity = 0;
            Hashtable sauceOptions = mItem.getOptions();
            sauceOptions.put("barbeque", false);
            sauceOptions.put("hot", false);
            sauceOptions.put("ranch", false);
            sauceOptions.put("ketchup", false);
            mNameTextView = (TextView) view.findViewById(R.id.eggroll_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.eggroll_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.eggroll_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.eggroll_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.eggroll_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.eggroll_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("barbeque");
                    mItem.getOptions().put("barbeque", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.eggroll_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("hot");
                    mItem.getOptions().put("hot", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.eggroll_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ranch");
                    mItem.getOptions().put("ranch", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.eggroll_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ketchup");
                    mItem.getOptions().put("ketchup", !checked);
                }
            });
        }

        // Vegie eggroll layout
        if (mLayoutResId == R.layout.customize_vegie_eggroll_fragment) {
//            mQuantity = 0;
            Hashtable sauceOptions = mItem.getOptions();
            sauceOptions.put("barbeque", false);
            sauceOptions.put("hot", false);
            sauceOptions.put("ranch", false);
            sauceOptions.put("ketchup", false);
            mNameTextView = (TextView) view.findViewById(R.id.eggroll_vegie_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.eggroll_vegie_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.eggroll_vegie_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.eggroll_vegie_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.eggroll_vegie_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.eggroll_vegie_barbeque);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("barbeque");
                    mItem.getOptions().put("barbeque", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.eggroll_vegie_hot);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("hot");
                    mItem.getOptions().put("hot", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.eggroll_vegie_ranch);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ranch");
                    mItem.getOptions().put("ranch", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.eggroll_vegie_ketchup);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("ketchup");
                    mItem.getOptions().put("ketchup", !checked);
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
            Hashtable<String, Boolean> smoothieOptions = mItem.getOptions();
            smoothieOptions.put("strawberry", false);
            smoothieOptions.put("pineapple", false);
            smoothieOptions.put("banana", false);
            smoothieOptions.put("forbidden_fruit", false);
            smoothieOptions.put("mango", false);
            smoothieOptions.put("lemonade", false);
            mNameTextView = (TextView) view.findViewById(R.id.smoothie_item_name);
            mAddButtonView = (Button) view.findViewById(R.id.smoothie_add_button_view);
            mQuantityTextView = (TextView) view.findViewById(R.id.smoothie_quantity_text_view);
            mSubtractButtonView = (Button) view.findViewById(R.id.smoothie_subtract_button_view);
            mOrderButtonView = (Button) view.findViewById(R.id.smoothie_order_button);

            mOption1 = (CheckBox) view.findViewById(R.id.smoothie_strawberry);
            mOption1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("strawberry");
                    mItem.getOptions().put("strawberry", !checked);
                }
            });

            mOption2 = (CheckBox) view.findViewById(R.id.smoothie_pineapple);
            mOption2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("pineapple");
                    mItem.getOptions().put("pineapple", !checked);
                }
            });

            mOption3 = (CheckBox) view.findViewById(R.id.smoothie_banana);
            mOption3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("banana");
                    mItem.getOptions().put("banana", !checked);
                }
            });

            mOption4 = (CheckBox) view.findViewById(R.id.smoothie_forbidden_fruit);
            mOption4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("forbidden_fruit");
                    mItem.getOptions().put("forbidden_fruit", !checked);
                }
            });

            mOption5 = (CheckBox) view.findViewById(R.id.smoothie_mango);
            mOption5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("mango");
                    mItem.getOptions().put("mango", !checked);
                }
            });

            mOption6 = (CheckBox) view.findViewById(R.id.smoothie_lemonade);
            mOption6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean checked = (Boolean) mItem.getOptions().get("lemonade");
                    mItem.getOptions().put("lemonade", !checked);
                }
            });

        }


        mNameTextView.setText(mItem.getName());

        mAddButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuantity++;
                mQuantityTextView.setText("" + mQuantity);
                if (mQuantity != 0) {
                    mOrderButtonView.setEnabled(true);
                } else {
                    mOrderButtonView.setEnabled(false);
                }
            }
        });

        mSubtractButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuantity > 0) {
                    mQuantity--;
                    mQuantityTextView.setText("" + mQuantity);
                    if (mQuantity != 0) {
                        mOrderButtonView.setEnabled(true);
                    } else {
                        mOrderButtonView.setEnabled(false);
                    }
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
