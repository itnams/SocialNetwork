package com.example.socialnetwork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
public class HomeBlankFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_home_blank, container, false);
        RecyclerView recyitem = view.findViewById(R.id.recyitem);
        recyitem.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyitem.setLayoutManager(layoutManager);
        ArrayList<dataPost>arrayList = new ArrayList<>();
        arrayList.add(new dataPost(R.drawable.home,"Nguyen Viet Nam","10:20","ádfffffffff"));
        arrayList.add(new dataPost(R.drawable.home,"Nguyen Viet Nam","10:20","sssssssssssssssss"));
        arrayList.add(new dataPost(R.drawable.home,"Nguyen Viet Nam","10:20","ádfffffffff"));
        arrayList.add(new dataPost(R.drawable.home,"Nguyen Viet Nam","10:20","aaaaaaaaaaaa"));
        arrayList.add(new dataPost(R.drawable.home,"Nguyen Viet Nam","10:20","aaaaaaaa"));
        arrayList.add(new dataPost(R.drawable.home,"Nguyen Viet Nam","10:20","sdfsagqwer"));
        postAdapter postAdapter = new postAdapter(arrayList,getContext().getApplicationContext());
        recyitem.setAdapter(postAdapter);
        return view;
    }
}