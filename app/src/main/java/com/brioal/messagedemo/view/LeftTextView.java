package com.brioal.messagedemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Brioal on 2016/6/20.
 */

public class LeftTextView extends TextView {
    private int mWidth;
    private int mHeight;
    private Paint mPaint;

    public LeftTextView(Context context) {
        this(context, null);
    }

    public LeftTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(new RectF(10, 10, mWidth - 10, mHeight - 10), 20, 20, mPaint);
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(30, 10);
        path.lineTo(0, 0);
        path.lineTo(10, 30);
        canvas.drawPath(path, mPaint);
    }
}
