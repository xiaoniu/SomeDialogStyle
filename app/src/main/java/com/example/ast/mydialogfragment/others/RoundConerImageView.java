package com.example.ast.mydialogfragment.others;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.ast.mydialogfragment.R;

/**
 * 上面两个角为圆角，下面两个角为直角的矩形图片
 * Created by AST on 2017/9/28.
 */

public class RoundConerImageView extends ImageView {

    public RoundConerImageView(Context context) {
        super(context);
    }

    public RoundConerImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(createRoundConerImage(BitmapFactory.decodeResource(getResources(), R.mipmap.empower_camera)), 0, 0, null);
    }

    /**
     * 根据原图添加圆角
     *
     * @param source
     * @return
     */
    private Bitmap createRoundConerImage(Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        RectF rect = new RectF(0, 0, source.getWidth(), source.getHeight());
        //一个圆角矩形
        canvas.drawRoundRect(rect, 45, 45, paint);
        //一个直角矩形，覆盖掉圆角矩形下面的两个圆角
        canvas.drawRect(0,source.getHeight()-45,source.getWidth(),source.getHeight(),paint);
        //取图片的交集
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //绘制图片
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }
}
