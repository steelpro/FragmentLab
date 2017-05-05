package com.example.zachb.fragmentlab;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

/* ZACHARY BETTERS
   CIS 282
   FRAGMENT LAB
   5/3/17
*/

public class MainActivity extends Activity implements FragmentOne.OnWeightSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //ADD FRAGMENTS TO FRAGMENT MANAGER
        FragmentOne f1 = new FragmentOne();
        fragmentTransaction.add(R.id.frag_container, f1);
        fragmentTransaction.addToBackStack(null);

        FragmentTwo f2 = new FragmentTwo();
        fragmentTransaction.add(R.id.frag_container_two, f2);
        fragmentTransaction.addToBackStack(null);

        //RUN MANAGER
        fragmentTransaction.commit();
    }

    @Override
    public void setWeight(double weight) {
        //PASS DATA BETWEEN FRAGMENTS
        FragmentTwo f2 = (FragmentTwo) getFragmentManager().findFragmentById(R.id.frag_container_two);
        f2.updateInfo(weight);
    }
}