package com.ehsanrc.boipoka.controllers;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ehsanrc.boipoka.R;
import com.ehsanrc.boipoka.adapters.ReviewAdapter;

import java.util.ArrayList;

public class Reviews extends Fragment {

    public Reviews() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_reviews, container, false);

        FloatingActionButton fab = (FloatingActionButton) container.findViewById(R.id.fab_reviews);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v, "Write a review...", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        Button btn = (Button) container.findViewById(R.id.btn_test);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"Review Is Submitted",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),AddReview.class);
//                startActivity(intent);
//
//            }
//        });

        ArrayList<String> users = new ArrayList<String>();

        users.add("Raji");
        users.add("Pappu");
        users.add("Jaki");
        users.add("Ovi");


        ListView reviewList = (ListView) view.findViewById(R.id.list_review);

        ReviewAdapter adapter = new ReviewAdapter(getActivity(),users);
        reviewList.setAdapter(adapter);

        return view;


    }


}
