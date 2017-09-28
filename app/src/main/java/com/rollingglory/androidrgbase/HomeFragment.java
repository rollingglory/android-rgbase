package com.rollingglory.androidrgbase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rollingglory.androidrgbase.base.BaseFragment;
import com.rollingglory.androidrgbase.page.color.ColorFragment;

import butterknife.ButterKnife;


/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public class HomeFragment extends BaseFragment {

    public static HomeFragment newInstance() {
        HomeFragment f = new HomeFragment();
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View onBaseCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

}
