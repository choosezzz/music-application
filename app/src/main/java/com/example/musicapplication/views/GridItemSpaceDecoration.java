package com.example.musicapplication.views;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author choosezzz
 * @date 3/17/21 9:51 PM
 *
 * 自定义网格item装饰（分割样式）
 */
public class GridItemSpaceDecoration extends RecyclerView.ItemDecoration {

    /**
     * 分割线宽度
     */
    private int space;

    public GridItemSpaceDecoration(int space, RecyclerView parent) {
        this.space = space;
        setRecyclerViewMargin(parent);
    }

    /**
     * 设置元素之间偏移量
     *
     * 通过让每个itemView相对边界进行偏移，达到空白分割的样式
     * @param outRect Item的矩形边界
     * @param view ItemView本身
     * @param parent RecyclerView
     * @param state Recycler的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //设置item相对于边界向右偏移space
        outRect.left = space;
    }

    /**
     * 设置父view的margin属性
     * @param parent
     */
    public void setRecyclerViewMargin(RecyclerView parent) {
        //设置RecyclerView全局的leftMargin，第一个图片的偏移量抵消
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        //margin为正，则距离边界产生一个距离
        //margin为负，则超出边界产生一个距离
        layoutParams.leftMargin = -space;
        parent.setLayoutParams(layoutParams);
    }
}
