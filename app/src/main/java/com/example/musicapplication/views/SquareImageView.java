package com.example.musicapplication.views;


import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author choosezzz
 * @date 3/17/21 9:26 PM
 *
 * 自定义正方形ImageView
 * 重写宽高度量方法
 */
public class SquareImageView extends AppCompatImageView {


    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //高度使用宽度，达到宽高相等的效果
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

        //view宽度
        //int size = MeasureSpec.getSize(widthMeasureSpec);
        //获取view模式: match_parent、wrap_parent、dp
        //MeasureSpec.getMode(heightMeasureSpec);

    }
}
