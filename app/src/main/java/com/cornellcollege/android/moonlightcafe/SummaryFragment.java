package com.cornellcollege.android.moonlightcafe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Tibuchuba on 9/21/2015.
 */
public class SummaryFragment extends Fragment {

    private Item mItem;
    private int mQuantity;
    private int mSupplements = 0;

    private TextView mItemNameTextView;
    private TextView mQuantityTextView;

    private TextView mOption1TextView;
    private TextView mOption2TextView;
    private TextView mOption3TextView;
    private TextView mOption4TextView;
    private TextView mOption5TextView;
    private TextView mOption6TextView;
    private TextView mOption7TextView;
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

        mQuantityTextView = (TextView) view.findViewById(R.id.summary_quantity_text_view);
        mQuantityTextView.setText(mQuantity + "");



        return view;
    }

}
