package com.example.ast.mydialogfragment.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ast.mydialogfragment.R;
import com.example.simplebutton.SimpleButton;

/**
 * 礼品活动Dialog
 * Created by xiaoniu on 2017/9/27.
 */

public class GiftDialogFragment extends DialogFragment implements View.OnClickListener{

    private SimpleButton mIvClose;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除Dialog的矩形背景
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        //点击window外的区域 是否消失
        getDialog().setCanceledOnTouchOutside(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lib_gift_app_dialog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mIvClose = (SimpleButton) view.findViewById(R.id.iv_close);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvents();
    }

    private void initEvents() {
        mIvClose.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.iv_close) {
            dismiss();
        }
    }
}
