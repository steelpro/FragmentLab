package com.example.zachb.fragmentlab;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    TextView txtBase;
    TextView txtAdded;
    TextView txtTotal;

    public FragmentTwo() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_two_layout, container, false);

        txtBase = (TextView) view.findViewById(R.id.txtBase);
        txtAdded = (TextView) view.findViewById(R.id.txtAdded);
        txtTotal = (TextView) view.findViewById(R.id.txtTotalShip);

        return view;
    }

    public void updateInfo(double weight) {

        //CALCULATE COST AFTER RECEIVING WEIGHT
        double baseCost = weight * 0.30;
        double addedCost = baseCost * 0.15;
        double totalCost = addedCost + baseCost;

        txtBase.setText(String.format("Base Cost: $%.2f", baseCost));
        txtAdded.setText(String.format("Added Cost: $%.2f", addedCost));
        txtTotal.setText(String.format("Total Shipping Cost: $%.2f", totalCost));
    }
}