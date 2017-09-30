package com.example.ast.mydialogfragment.dialogfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ast.mydialogfragment.R;
import com.example.simplebutton.utils.ColorUtil;
import com.example.simplebutton.utils.DrawableUtil;

/**
 * 版本更新Dialog
 * Created by xiaoniu on 2017/9/27.
 */

public class UpdateDialogFragment extends DialogFragment implements View.OnClickListener {
    private static final String TAG = "UpdateDialogFragment";
    //更新按钮
    private Button mUpdateOkButton;
    //关闭diaolog
    private ImageView mIvClose;
    //默认色
    private int mDefaultColor = 0xffe94339;
    //顶部图片
    private int mDefaultPicResId = R.mipmap.lib_update_app_top_bg;
    private ImageView mTopIv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除Dialog的矩形背景
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
        //点击window外的区域 是否消失
        getDialog().setCanceledOnTouchOutside(false);
        //是否可以取消,会影响上面那条属性
//        setCancelable(false);
//        //window外可以点击,不拦截窗口外的事件
//        getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

        //设置Dialog高度为页面高度的80%
        Window dialogWindow = getDialog().getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        lp.height = (int) (displayMetrics.heightPixels * 0.8f);
        dialogWindow.setAttributes(lp);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lib_update_app_dialog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mUpdateOkButton = (Button) view.findViewById(R.id.btn_ok);
        mIvClose = (ImageView) view.findViewById(R.id.iv_close);
        mTopIv = (ImageView) view.findViewById(R.id.iv_top);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initTheme();
        initEvents();
    }


    /**
     * 初始化主题色
     */
    private void initTheme() {
        //默认红色
        setDialogTheme(mDefaultColor, mDefaultPicResId);
    }

    /**
     * 设置
     *
     * @param color    主色
     * @param topResId 图片
     */
    private void setDialogTheme(int color, int topResId) {
        mTopIv.setImageResource(topResId);
        mUpdateOkButton.setBackgroundDrawable(DrawableUtil.getDrawable(3, color));
        //随背景颜色变化
        mUpdateOkButton.setTextColor(ColorUtil.isTextColorDark(color) ? Color.BLACK : Color.WHITE);
    }

    private void initEvents() {
        mUpdateOkButton.setOnClickListener(this);
        mIvClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.iv_close) {
            dismiss();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
