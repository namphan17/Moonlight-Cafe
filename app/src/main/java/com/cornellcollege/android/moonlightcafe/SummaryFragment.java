package com.cornellcollege.android.moonlightcafe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

/**
 * Fragment displaying a summary of the order and option to finalize order
 */
public class SummaryFragment extends Fragment {

    private Item mItem;
    private int mQuantity;
    private int mSupplements = 0;
    private double mTotalPrice;
    private Button orderButto;

    private TextView mItemNameTextView;
    private TextView mQuantityTextView;

    private TextView mOption1TextView;
    private TextView mOption2TextView;
    private TextView mOption3TextView;
    private TextView mOption4TextView;
    private TextView mOption5TextView;
    private TextView mOption6TextView;
    private TextView mOption7TextView;
    private TextView mOption8TextView;
    private TextView mOption9TextView;

    private TextView mOptionTextView;

    private TextView mPriceTextView;

    public static final String ARG_ITEM_SUM_ID =
            "Summary_For_Item";
    public static final String ARG_QUANTITY =
            "Item_Quantity";

    public static SummaryFragment newInstance(UUID itemId, int mQuantity) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_SUM_ID, itemId);
        args.putInt(ARG_QUANTITY, mQuantity);

        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID id = (UUID) getArguments().getSerializable(ARG_ITEM_SUM_ID);
        mItem = ItemLab.get(getActivity()).getItem(id);
        mQuantity = getArguments().getInt(ARG_QUANTITY);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        mItemNameTextView = (TextView) view.findViewById(R.id.summary_name_text_view);
        mItemNameTextView.setText(mItem.getName());

        mQuantityTextView = (TextView) view.findViewById(R.id.summary_quantity_text_view);
        mQuantityTextView.setText(mQuantity + "");

        mOption1TextView = (TextView) view.findViewById(R.id.option1_text_view);
        mOption2TextView = (TextView) view.findViewById(R.id.option2_text_view);
        mOption3TextView = (TextView) view.findViewById(R.id.option3_text_view);
        mOption4TextView = (TextView) view.findViewById(R.id.option4_text_view);
        mOption5TextView = (TextView) view.findViewById(R.id.option5_text_view);
        mOption6TextView = (TextView) view.findViewById(R.id.option6_text_view);
        mOption7TextView = (TextView) view.findViewById(R.id.option7_text_view);
        mOption8TextView = (TextView) view.findViewById(R.id.option8_text_view);
        mOption9TextView = (TextView) view.findViewById(R.id.option9_text_view);

        mPriceTextView = (TextView) view.findViewById(R.id.summary_price);

        String foodItem = mItem.getName();

        switch(foodItem) {
            case "Pizza":
                if ((Boolean) mItem.getOptions().get("pepperoni")) {
                    mSupplements++;
                    mOption1TextView.setText("Pepperoni       ");
                }
                if ((Boolean) mItem.getOptions().get("bacon")) {
                    mSupplements++;
                    mOption2TextView.setText("Bacon       ");
                }
                if ((Boolean) mItem.getOptions().get("onion")) {
                    mSupplements++;
                    mOption3TextView.setText("Onion       ");
                }
                if ((Boolean) mItem.getOptions().get("black_olives")) {
                    mSupplements++;
                    mOption4TextView.setText("Black Olives       ");
                }
                if ((Boolean) mItem.getOptions().get("sausage")) {
                    mSupplements++;
                    mOption5TextView.setText("Sausage       ");
                }
                if ((Boolean) mItem.getOptions().get("mushroom")) {
                    mSupplements++;
                    mOption6TextView.setText("Mushroom       ");
                }
                if ((Boolean) mItem.getOptions().get("extra_cheese")) {
                    mSupplements++;
                    mOption7TextView.setText("Extra Cheese       ");
                }
                if ((Boolean) mItem.getOptions().get("chicken")) {
                    mSupplements++;
                    mOption8TextView.setText("Chicken       ");
                }
                if ((Boolean) mItem.getOptions().get("pineapple")) {
                    mSupplements++;
                    mOption9TextView.setText("Pineapple       ");
                }
                break;
            case "Burger":
                if ((Boolean) mItem.getOptions().get("lettuce")) {
                    mSupplements++;
                    mOption1TextView.setText("Lettuce       ");
                }
                if ((Boolean) mItem.getOptions().get("pickles")) {
                    mSupplements++;
                    mOption2TextView.setText("Pickles       ");
                }
                if ((Boolean) mItem.getOptions().get("onion")) {
                    mSupplements++;
                    mOption3TextView.setText("Onion       ");
                }
                if ((Boolean) mItem.getOptions().get("tomatoes")) {
                    mSupplements++;
                    mOption4TextView.setText("Tomatoes       ");
                }
                if ((Boolean) mItem.getOptions().get("cucumber")) {
                    mSupplements++;
                    mOption5TextView.setText("Cucumber       ");
                }
                if ((Boolean) mItem.getOptions().get("cheese")) {
                    mSupplements++;
                    mOption6TextView.setText("Cheese       ");
                }
                if ((Boolean) mItem.getOptions().get("bacon")) {
                    mSupplements++;
                    mOption7TextView.setText("Bacon       ");
                }
                break;
            case "Chicken Tender":
                if ((Boolean) mItem.getOptions().get("barbeque")) {
                    mSupplements++;
                    mOption1TextView.setText("Barbeque       ");
                }
                if ((Boolean) mItem.getOptions().get("hot")) {
                    mSupplements++;
                    mOption2TextView.setText("Hot       ");
                }
                if ((Boolean) mItem.getOptions().get("ranch")) {
                    mSupplements++;
                    mOption3TextView.setText("Ranch       ");
                }
                if ((Boolean) mItem.getOptions().get("ketchup")) {
                    mSupplements++;
                    mOption4TextView.setText("Ketchup       ");
                }
                break;
            case "Fries":
                if ((Boolean) mItem.getOptions().get("barbeque")) {
                    mSupplements++;
                    mOption1TextView.setText("Barbeque       ");
                }
                if ((Boolean) mItem.getOptions().get("hot")) {
                    mSupplements++;
                    mOption2TextView.setText("Hot       ");
                }
                if ((Boolean) mItem.getOptions().get("ranch")) {
                    mSupplements++;
                    mOption3TextView.setText("Ranch       ");
                }
                if ((Boolean) mItem.getOptions().get("ketchup")) {
                    mSupplements++;
                    mOption4TextView.setText("Ketchup       ");
                }
                break;
            case "Eggroll(Pork)":
                if ((Boolean) mItem.getOptions().get("barbeque")) {
                    mSupplements++;
                    mOption1TextView.setText("Barbeque       ");
                }
                if ((Boolean) mItem.getOptions().get("hot")) {
                    mSupplements++;
                    mOption2TextView.setText("Hot       ");
                }
                if ((Boolean) mItem.getOptions().get("ranch")) {
                    mSupplements++;
                    mOption3TextView.setText("Ranch       ");
                }
                if ((Boolean) mItem.getOptions().get("ketchup")) {
                    mSupplements++;
                    mOption4TextView.setText("Ketchup       ");
                }
                break;
            case "Eggroll(Vegie)":
                break;
            case "Grilled Cheese":
                break;
            case "Smoothie":
                if ((Boolean) mItem.getOptions().get("strawberry")) {
                    mSupplements++;
                    mOption1TextView.setText("Strawberry       ");
                }
                if ((Boolean) mItem.getOptions().get("pineapple")) {
                    mSupplements++;
                    mOption2TextView.setText("Pineapple       ");
                }
                if ((Boolean) mItem.getOptions().get("banana")) {
                    mSupplements++;
                    mOption3TextView.setText("Banana       ");
                }
                if ((Boolean) mItem.getOptions().get("forbidden_fruit")) {
                    mSupplements++;
                    mOption4TextView.setText("Forbidden Fruit       ");
                }
                if ((Boolean) mItem.getOptions().get("mango")) {
                    mSupplements++;
                    mOption3TextView.setText("Mango       ");
                }
                if ((Boolean) mItem.getOptions().get("lemonade")) {
                    mSupplements++;
                    mOption3TextView.setText("Lemonade       ");
                }
                break;
        }

        mTotalPrice = mItem.getPrice()*mQuantity + mSupplements*1.5;
        mPriceTextView.setText("$" + mTotalPrice);

        return view;
    }


}
