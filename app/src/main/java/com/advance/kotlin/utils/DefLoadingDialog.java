package com.advance.kotlin.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.advance.kotlin.R;


/**
 * 默认加载dialog
 */
public class DefLoadingDialog extends Dialog {
    private TextView tvHint;

    private ImageView iv_success;
    private ImageView iv_error;
    private ImageView iv_loadgif;
    private ImageView iv_warn;

    private AnimationDrawable loadBg;

    public DefLoadingDialog(Context context) {
        // 创建自定义样式dialog
        super(context, R.style.loading_dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);
        RelativeLayout layout = v.findViewById(R.id.dialog_view);

        tvHint = v.findViewById(R.id.tv_loading_title);
        iv_success = v.findViewById(R.id.success);
        iv_error = v.findViewById(R.id.error);
        iv_loadgif = v.findViewById(R.id.loadgif);
        iv_warn = v.findViewById(R.id.iv_warn);

        String tips = "加载中";
        tvHint.setText(tips);

        setContentView(layout, new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.CommonDialogAnim);
        }
    }

    public void setTvHint(String tips) {
        if (tvHint != null) {
            tvHint.setText(tips);
        }
    }

    public void show(String tip) {
        show(tip, true);
    }

    public void show(String tip, boolean cancelable) {
        iv_error.setVisibility(View.GONE);
        iv_loadgif.setVisibility(View.VISIBLE);
        iv_warn.setVisibility(View.GONE);
        iv_success.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(tip)) {
            tvHint.setText(tip);
        }
        setCancelable(cancelable);
        setCanceledOnTouchOutside(cancelable);
        this.show();
    }


    @Override
    public void show() {
        super.show();
        loadBg = (AnimationDrawable) iv_loadgif.getDrawable();
        loadBg.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (loadBg != null) {
            loadBg.stop();
        }
    }

}
