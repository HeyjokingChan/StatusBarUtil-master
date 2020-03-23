package com.leaf.statusbarutil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class SecondFragment extends Fragment {

    private static final Integer[] CATS = new Integer[]{
            R.mipmap.cat_1,
            R.mipmap.cat_2,
            R.mipmap.cat_3,
            R.mipmap.cat_4,
            R.mipmap.cat_5,
            R.mipmap.cat_6,
            R.mipmap.cat_7,
            R.mipmap.cat_8,
            R.mipmap.cat_9,
            R.mipmap.cat_10
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecycler = getView().findViewById(R.id.mRecycler);

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mRecycler.setLayoutManager(staggeredGridLayoutManager);

        List<Integer> data = Arrays.asList(CATS);
        SecondAdapter mAdapter = new SecondAdapter(getContext(), data);
        mRecycler.setAdapter(mAdapter);
    }
}
