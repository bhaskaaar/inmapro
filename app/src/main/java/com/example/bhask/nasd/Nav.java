package com.example.bhask.nasd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Nav extends android.support.v4.app.Fragment {
    public String itemText1;
    public String itemText2;
    Spinner spinner;
    Spinner spinner2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("NAV");
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
                itemText1 = (String) spinner.getSelectedItem();
                itemText2 = (String) spinner2.getSelectedItem();
                Fragment fragment = null;

                switch (itemText1) {
                    case "Main Gate":
                        switch (itemText2){
                            case "Main Gate":
                                fragment = new wow();
                                replaceFragment(fragment);
                                break;
                            case "Babbage":
                                fragment = new main2bab();
                                replaceFragment(fragment);
                                break;
                            case "Square 1":
                                fragment = new main2sq();
                                replaceFragment(fragment);
                                break;
                            case "Exploretorium":
                                fragment = new main2explo();
                                replaceFragment(fragment);
                                break;
                        }
                        break;
                    case "Babbage":
                        switch (itemText2){
                            case "Babbage":
                                fragment = new wow();
                                replaceFragment(fragment);
                                break;
                            case "Main Gate":
                                fragment = new bab2main();
                                replaceFragment(fragment);
                                break;
                            case "Square 1":
                                fragment = new bab2sq();
                                replaceFragment(fragment);
                                break;
                            case "Exploretorium":
                                fragment = new bab2explo();
                                replaceFragment(fragment);
                                break;
                        }
                        break;
                    case "Square 1":
                        switch (itemText2){
                            case "Square 1":
                                fragment = new wow();
                                replaceFragment(fragment);
                                break;
                            case "Babbage":
                                fragment = new sq2bab();
                                replaceFragment(fragment);
                                break;
                            case "Main Gate":
                                fragment = new sq2main();
                                replaceFragment(fragment);
                                break;
                            case "Exploretorium":
                                fragment = new sq2explo();
                                replaceFragment(fragment);
                                break;
                        }
                        break;
                    case "Exploretorium":
                        switch (itemText2){
                            case "Exploretorium":
                                fragment = new wow();
                                replaceFragment(fragment);
                                break;
                            case "Babbage":
                                fragment = new explo2bab();
                                replaceFragment(fragment);
                                break;
                            case "Square 1":
                                fragment = new explo2sq();
                                replaceFragment(fragment);
                                break;
                            case "Main Gate":
                                fragment = new explo2main();
                                replaceFragment(fragment);
                                break;
                        }
                        break;


                }
            }
        });
        spinner = (Spinner) view.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter);
        itemText1 = (String) spinner.getSelectedItem();
        itemText2 = (String) spinner2.getSelectedItem();
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
