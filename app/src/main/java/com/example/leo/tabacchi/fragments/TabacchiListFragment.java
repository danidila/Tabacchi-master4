package com.example.leo.tabacchi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leo.tabacchi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabacchiListFragment extends Fragment {


    public TabacchiListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabacchi_list, container, false);
    }

}
