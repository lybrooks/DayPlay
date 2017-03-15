package com.example.guowang.mto.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.guowang.mto.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class CarDialog extends Dialog {
    Context mcontext;

    public CarDialog(Context context) {
        super(context);
    }

    public CarDialog(Context context, int themeResId) {
        super(context, themeResId);
        mcontext = context;
    }

    protected CarDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.cardialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_dialog_red, R.id.iv_dialog_purple, R.id.iv_dialog_bule,
            R.id.iv_dialog_green, R.id.iv_dialog_d_green, R.id.iv_dialog_yellow,
            R.id.iv_dialog_d_yellow, R.id.iv_dialog_pick, R.id.tv_dialog_quxiao})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_dialog_red:
                break;
            case R.id.iv_dialog_purple:

                break;
            case R.id.iv_dialog_bule:
                break;
            case R.id.iv_dialog_green:
                break;
            case R.id.iv_dialog_d_green:
                break;
            case R.id.iv_dialog_yellow:
                break;
            case R.id.iv_dialog_d_yellow:
                break;
            case R.id.iv_dialog_pick:
                break;
            case R.id.tv_dialog_quxiao:
                Toast.makeText(mcontext, "aaaa", Toast.LENGTH_SHORT).show();
                this.dismiss();
                break;
        }
    }
}
