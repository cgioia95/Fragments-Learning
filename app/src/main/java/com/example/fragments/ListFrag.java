package com.example.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {


    public ListFrag() {
        // Required empty public constructor
    }

    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected)context;




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data = new ArrayList<String>();
        data.add("1. This is item 1");
        data.add("2. This is item 2");
        data.add("3. This is item 3");

        setListAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data));
        activity.onItemSelected(0);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        activity.onItemSelected(position);


    }



}
