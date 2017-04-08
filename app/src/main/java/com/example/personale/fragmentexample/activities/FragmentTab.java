package com.example.personale.fragmentexample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.personale.fragmentexample.R;

/**
 * Created by personale on 06/04/2017.
 */

public class FragmentTab extends Fragment {

    private FragmentTabHost th;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab, container, false);

        th = (FragmentTabHost) v.findViewById(android.R.id.tabhost);
        th.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        th.addTab(th.newTabSpec("ListMap").setIndicator("List Map"), ListFragment.class, null);
        th.addTab(th.newTabSpec("Request").setIndicator("Request API"), RequestFragment.class, null);

        return v;
    }
}
