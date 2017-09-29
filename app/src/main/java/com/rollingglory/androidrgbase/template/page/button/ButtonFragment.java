package com.rollingglory.androidrgbase.template.page.button;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rollingglory.androidrgbase.R;
import com.rollingglory.androidrgbase.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public class ButtonFragment extends BaseFragment {

    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.btn_minus)
    ImageButton btnMinus;
    @BindView(R.id.btn_add)
    ImageButton btnAdd;

    int amount = 0;

    public static ButtonFragment newInstance() {
        ButtonFragment f = new ButtonFragment();
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
        View v = inflater.inflate(R.layout.fragment_button, container, false);
        ButterKnife.bind(this, v);

        btnMinus.setEnabled(false);

        return v;
    }

    @OnClick({R.id.btn_minus, R.id.btn_add})
    public void amountChanged(View v) {
        switch (v.getId()) {
            case R.id.btn_minus:
                amount--;
                tvAmount.setText(getString(R.string.integer, amount));
                break;
            case R.id.btn_add:
                amount++;
                tvAmount.setText(getString(R.string.integer, amount));
                break;
            default:
        }
        if (amount == 0) {
            btnMinus.setEnabled(false);
        } else if (amount == 10) {
            btnAdd.setEnabled(false);
        } else {
            btnMinus.setEnabled(true);
            btnAdd.setEnabled(true);
        }
    }

}
