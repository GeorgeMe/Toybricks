package com.yunyan.toybricks.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunyan.toybricks.R;
import com.yunyan.toybricks.adapter.ObjectGridAdapter;
import com.yunyan.toybricks.adapter.RecyclerViewMaterialAdapter;
import com.yunyan.toybricks.entity.ToyBricksProduct;

import java.util.ArrayList;


public class ToyBricksGridFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<ToyBricksProduct> cards = new ArrayList<>();

    public ToyBricksGridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.toybricks_fragment_recyclerview, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager =  new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        for(int k=0;k<=100;k++){
            ToyBricksProduct obj = new ToyBricksProduct();

            cards.add(obj);
        }
        mAdapter = new RecyclerViewMaterialAdapter(new ObjectGridAdapter(cards,getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        return view;

    }

    public void onButtonPressed(Uri uri) {

    }

}
