package com.rollingglory.androidrgbase.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public abstract class BaseFragment extends Fragment {

    protected abstract View onBaseCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return onBaseCreateView(inflater, container, savedInstanceState);
    }

}
