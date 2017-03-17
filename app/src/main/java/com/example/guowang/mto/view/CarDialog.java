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
import com.example.guowang.mto.utils.ThemeHelper;

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

    ImageView ArrColorImaeg[];
    private ClickListener mClickListener;


    private int mCurrentTheme;

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
        initView();
    }

    private void initView() {
        ArrColorImaeg = new ImageView[]{ivDialogRed, ivDialogPurple, ivDialogBule, ivDialogGreen, ivDialogDGreen, ivDialogYellow,
                ivDialogDYellow, ivDialogPick};
    }


    @OnClick({R.id.iv_dialog_red, R.id.iv_dialog_purple, R.id.iv_dialog_bule,
            R.id.iv_dialog_green, R.id.iv_dialog_d_green, R.id.iv_dialog_yellow,
            R.id.iv_dialog_d_yellow, R.id.iv_dialog_pick, R.id.tv_dialog_quxiao})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_dialog_red:
                mCurrentTheme = ThemeHelper.CARD_SAKURA;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_purple:
                mCurrentTheme = ThemeHelper.CARD_HOPE;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_bule:
                mCurrentTheme = ThemeHelper.CARD_STORM;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_green:
                mCurrentTheme = ThemeHelper.CARD_WOOD;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_d_green:
                mCurrentTheme = ThemeHelper.CARD_LIGHT;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_yellow:
                mCurrentTheme = ThemeHelper.CARD_THUNDER;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_d_yellow:
                mCurrentTheme = ThemeHelper.CARD_SAND;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.iv_dialog_pick:
                mCurrentTheme = ThemeHelper.CARD_FIREY;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.tv_dialog_quxiao:
                this.dismiss();
                break;
            case R.id.tv_dialog_OK:
                if (mClickListener != null) {
                    mClickListener.onConfirm(mCurrentTheme);
                }
                break;
        }
    }


    private void setImageButtons(int currentTheme) {
        ArrColorImaeg[0].setSelected(currentTheme == ThemeHelper.CARD_SAKURA);
        ArrColorImaeg[1].setSelected(currentTheme == ThemeHelper.CARD_HOPE);
        ArrColorImaeg[2].setSelected(currentTheme == ThemeHelper.CARD_STORM);
        ArrColorImaeg[3].setSelected(currentTheme == ThemeHelper.CARD_WOOD);
        ArrColorImaeg[4].setSelected(currentTheme == ThemeHelper.CARD_LIGHT);
        ArrColorImaeg[5].setSelected(currentTheme == ThemeHelper.CARD_THUNDER);
        ArrColorImaeg[6].setSelected(currentTheme == ThemeHelper.CARD_SAND);
        ArrColorImaeg[7].setSelected(currentTheme == ThemeHelper.CARD_FIREY);
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }
    public interface ClickListener {
        void onConfirm(int currentTheme);
    }

}



