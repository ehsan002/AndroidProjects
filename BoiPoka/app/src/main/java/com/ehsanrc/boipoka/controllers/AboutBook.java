package com.ehsanrc.boipoka.controllers;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehsanrc.boipoka.R;

public class AboutBook extends Fragment {

    public AboutBook() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FloatingActionButton fab1 = (FloatingActionButton) container.findViewById(R.id.fab_about);

        return inflater.inflate(R.layout.activity_about_book, container, false);


    }
}
