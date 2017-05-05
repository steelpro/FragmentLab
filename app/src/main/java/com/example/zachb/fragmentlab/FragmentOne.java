package com.example.zachb.fragmentlab;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentOne extends Fragment {

    Button btnSubmit;
    EditText etWeight;
    OnWeightSetListener onWeightSetListener;

    public FragmentOne() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one_layout, container, false);

        etWeight = (EditText) view.findViewById(R.id.etWeight);

        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!etWeight.getText().toString().matches("")) {
                    double ounces = Double.parseDouble(etWeight.getText().toString());
                    onWeightSetListener.setWeight(ounces); //PASS DATA TO FRAGMENT
                }
                else
                    Toast.makeText(getActivity(), "No data to pass!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    public interface OnWeightSetListener {
        public void setWeight(double weight);
    }

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        try {
            onWeightSetListener = (OnWeightSetListener) activity;
        }
        catch (Exception e) {}
    }
}