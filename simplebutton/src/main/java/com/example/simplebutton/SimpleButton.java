package com.example.simplebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.example.simplebutton.utils.ColorUtil;
import com.example.simplebutton.utils.DrawableUtil;

/**
 * 简单好看的自定义Button
 * Created by xiaoniu on 2017/9/26.
 */

public class SimpleButton extends Button {

    private static final String TAG = SimpleButton.class.getSimpleName();
    //样式：有normal，stroke，solid三种
    private int style;
    //颜色
    private int color;
    //边框宽
    private int strokeWidth;
    //圆角半径
    private int cornerRadius;

    final int STYLE_NORMAL = 0;
    final int STYLE_STROKE = 1;
    final int STYLE_SOLID = 2;
    //默认颜色蓝色
    final int DEF_COLOR = Color.parseColor("#3f51b5");

    public SimpleButton(Context context) {
        super(context);
    }

    public SimpleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SimpleButton);
        style = ta.getInt(R.styleable.SimpleButton_style, STYLE_NORMAL);
        color = ta.getColor(R.styleable.SimpleButton_color, DEF_COLOR);
        strokeWidth = ta.getDimensionPixelSize(R.styleable.SimpleButton_strokeWidth, 6);
        cornerRadius = ta.getDimensionPixelSize(R.styleable.SimpleButton_cornerRadius, 10);
        ta.recycle();  //注意回收
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void init() {
        switch (style) {
            case STYLE_NORMAL:
                setStyleNormal();
                break;
            case STYLE_STROKE:
                setStyleStroke();
                break;
            case STYLE_SOLID:
                setStyleSolid();
                break;
        }
    }

    /**
     * 设置正常样式
     */
    private void setStyleNormal() {
        Log.i(TAG, "setStyleNormal");
        setBackgroundDrawable(DrawableUtil.getDrawable(cornerRadius, color));
    }

    /**
     * 空心样式
     */
    private void setStyleStroke() {
        Log.i(TAG, "setStyleStroke");
        setBackgroundDrawable(DrawableUtil.getStrokeSolidDrawable(cornerRadius, strokeWidth, color, Color.WHITE));
        setTextColor(ColorUtil.getColorStateList(Color.WHITE, color));
    }

    /**
     * 实心样式
     */
    private void setStyleSolid() {
        Log.i(TAG, "setStyleSolid");
        setBackgroundDrawable(DrawableUtil.getSolidStrokeDrawable(cornerRadius, strokeWidth, Color.WHITE, color));
        setTextColor(ColorUtil.getColorStateList(color, Color.WHITE));
    }

    public int getButtonStyle() {
        return style;
    }

    public void setButtonStyle(int style) {
        this.style = style;
    }

    public int getButtonColor() {
        return color;
    }

    public void setButtonColor(int color) {
        this.color = color;
    }

    public int getButtonStrokeWidth() {
        return strokeWidth;
    }

    public void setButtonStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getButtonCornerRadius() {
        return cornerRadius;
    }

    public void setButtonCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }



}
