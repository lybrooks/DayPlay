package com.example.guowang.mto.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.guowang.mto.R;
import com.example.guowang.mto.utils.L;

import butterknife.Bind;
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
    @Bind(R.id.iv_dialog_red)
    ImageView ivDialogRed;
    @Bind(R.id.iv_dialog_purple)
    ImageView ivDialogPurple;
    @Bind(R.id.iv_dialog_bule)
    ImageView ivDialogBule;
    @Bind(R.id.iv_dialog_green)
    ImageView ivDialogGreen;
    @Bind(R.id.iv_dialog_d_green)
    ImageView ivDialogDGreen;
    @Bind(R.id.iv_dialog_yellow)
    ImageView ivDialogYellow;
    @Bind(R.id.iv_dialog_d_yellow)
    ImageView ivDialogDYellow;
    @Bind(R.id.iv_dialog_pick)
    ImageView ivDialogPick;

    ImageView ArrColorImaeg[] = {ivDialogRed, ivDialogPurple, ivDialogBule, ivDialogGreen, ivDialogDGreen, ivDialogYellow,
            ivDialogDYellow, ivDialogPick};


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
                ivDialogRed.setSelected(true);
                ivDialogPurple.setSelected(false);
                ivDialogBule.setSelected(false);
//               setChoose(0);
                break;
            case R.id.iv_dialog_purple:
//               setChoose(1);
                ivDialogPurple.setSelected(true);
                ivDialogRed.setSelected(false);
                ivDialogBule.setSelected(false);
//                ivDialogPurple.setImageResource(R.drawable.ic_check_white_18dp);
                break;
            case R.id.iv_dialog_bule:
                ivDialogBule.setSelected(true);
                ivDialogPurple.setSelected(false);
                ivDialogRed.setSelected(false);
//                ivDialogBule.setImageResource(R.drawable.ic_check_white_18dp);
                setChoose(2);
                break;
            case R.id.iv_dialog_green:
//                ivDialogGreen.setImageResource(R.drawable.ic_check_white_18dp);
                setChoose(3);
                break;
            case R.id.iv_dialog_d_green:
                setChoose(4);
//                ivDialogDGreen.setImageResource(R.drawable.ic_check_white_18dp);
                break;
            case R.id.iv_dialog_yellow:
                setChoose(5);
//                ivDialogYellow.setImageResource(R.drawable.ic_check_white_18dp);
                break;
            case R.id.iv_dialog_d_yellow:
                setChoose(6);
//                ivDialogDYellow.setImageResource(R.drawable.ic_check_white_18dp);
                break;
            case R.id.iv_dialog_pick:
//                ivDialogPick.setImageResource(R.drawable.ic_check_white_18dp);
                setChoose(7);
                break;
            case R.id.tv_dialog_quxiao:
                this.dismiss();
                break;
        }
    }

    private void setChoose(int j) {
        for (int i = 0; i < 8; i++) {
            L.e("ArrColorImaeg.length="+ArrColorImaeg.length);
            if (i == j) {
                ArrColorImaeg[j].setSelected(true);
                L.e(""+ArrColorImaeg[j]);
            } else {
                ArrColorImaeg[j].setSelected(false);
            }
        }
    }
}



