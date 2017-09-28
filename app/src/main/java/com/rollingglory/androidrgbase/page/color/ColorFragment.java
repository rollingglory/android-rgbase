package com.rollingglory.androidrgbase.page.color;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rollingglory.androidrgbase.R;
import com.rollingglory.androidrgbase.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import app.custom.view.ItemOffsetDecoration;
import app.model.Color;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public class ColorFragment extends BaseFragment {

    @BindView(R.id.recyclerview_main) RecyclerView recyclerViewMain;
    @BindView(R.id.recyclerview_other) RecyclerView recyclerViewOther;

    ColorListAdapter mainAdapter;
    ColorListAdapter otherAdapter;
    List<Color> mainColors;
    List<Color> otherColors;

    public static ColorFragment newInstance() {
        ColorFragment f = new ColorFragment();
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
        View v = inflater.inflate(R.layout.fragment_color, container, false);
        ButterKnife.bind(this, v);

        setupMainRecyclerView();
        setupOtherRecyclerView();

        return v;
    }

    private void setupOtherRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_spacing);
        recyclerViewOther.setLayoutManager(layoutManager);
        recyclerViewOther.addItemDecoration(itemDecoration);

        otherColors = getOtherColors();
        otherAdapter = new ColorListAdapter(getActivity(), otherColors);
        recyclerViewOther.setAdapter(otherAdapter);
    }

    private List<Color> getOtherColors() {
        List<Color> otherColors = new ArrayList<>();

        otherColors.add(new Color("Blue", android.graphics.Color.parseColor("#04589b"), "#04589b"));
        otherColors.add(new Color("Light Blue", android.graphics.Color.parseColor("#3b3a9df2"), "#3b3a9df2"));
        otherColors.add(new Color("Transparent Grey", android.graphics.Color.parseColor("#54c3c3c3"), "#54c3c3c3"));
        otherColors.add(new Color("Light Grey", android.graphics.Color.parseColor("#aeaeae"), "#aeaeae"));
        otherColors.add(new Color("Grey", android.graphics.Color.parseColor("#808285"), "#808285"));

        return otherColors;
    }

    private void setupMainRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_spacing);
        recyclerViewMain.setLayoutManager(layoutManager);
        recyclerViewMain.addItemDecoration(itemDecoration);

        mainColors = getMainColors();
        mainAdapter = new ColorListAdapter(getActivity(), mainColors);
        recyclerViewMain.setAdapter(mainAdapter);
    }

    private List<Color> getMainColors() {
        List<Color> mainColors = new ArrayList<>();

        mainColors.add(getColor(getContext().getResources(), R.string.color_primary, R.color.colorPrimary));
        mainColors.add(getColor(getContext().getResources(), R.string.color_secondary, R.color.colorPrimaryDark));
        mainColors.add(getColor(getContext().getResources(), R.string.color_accent, R.color.colorAccent));
        mainColors.add(getColor(getContext().getResources(), R.string.color_primary_text, R.color.colorTextPrimary));
        mainColors.add(getColor(getContext().getResources(), R.string.color_secondary_text, R.color.colorTextSecondary));

        return mainColors;
    }

    private Color getColor(Resources resources, int nameString, int colorResource) {
        int colorInt = ResourcesCompat.getColor(resources, colorResource, null);
        return new Color(
                resources.getString(nameString),
                colorInt,
                String.format("#%06X", (0xFFFFFF & colorInt))
        );
    }

}
