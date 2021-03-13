package com.example.musicapplication.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.musicapplication.R;

/**
 * @author choosezzz
 * @date 3/13/21 11:45 PM
 *
 * 输入控件，继承自FrameLayout
 * 1、输入icon
 * 2、输入框提示内容
 * 3、是否密文显示
 */
public class InputView extends FrameLayout {

    /**
     * 输入框icon
     */
    private int inputIcon;
    /**
     * 输入框提示
     */
    private String inputHint;
    /**
     * 是否密文
     */
    private boolean isPassword;

    private View view;
    private ImageView iconView;
    private EditText editText;


    public InputView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    /**
     * 初始化自定义输入控件
     * @param context 上下文
     * @@param attrs 属性集合
     */
    private void init(Context context, AttributeSet attrs) {

        if (attrs == null) {
            return;
        }
        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputView);
        inputIcon = typedArray.getResourceId(R.styleable.InputView_input_icon, R.mipmap.ic_main);
        inputHint = typedArray.getString(R.styleable.InputView_input_hint);
        isPassword = typedArray.getBoolean(R.styleable.InputView_is_password, false);
        //释放
        typedArray.recycle();

        //获取自定义view
        view = LayoutInflater.from(context).inflate(R.layout.input_view, this, false);
        iconView = view.findViewById(R.id.input_icon);
        editText = view.findViewById(R.id.input_edit_text);
        //布局关联自定义属性
        iconView.setImageResource(inputIcon);
        editText.setHint(inputHint);
        editText.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_PHONE);
        //添加自定义view
        addView(view);
    }

    /**
     * 获取输入内容
     * @return
     */
    private String getInputText() {
        return editText.getText().toString().trim();
    }
}
