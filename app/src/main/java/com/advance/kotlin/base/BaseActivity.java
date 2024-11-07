package com.advance.kotlin.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.advance.kotlin.R;


/**
 * 普通 activity 基类
 *
 * @author xugang
 * @date 2020/10/10
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected ViewDataBinding viewDataBinding;
    private ViewModelProvider mViewModelProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        this.initVariables();
        beforeSetContentView();
        initContent();

        // 初始化视图
        initView();
        loadData();
    }

    // 未使用layout的xml，viewDataBinding==null
    protected void initContent() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    /**
     * 在 SetContentView 之前的一些操作
     */
    protected void beforeSetContentView() {
    }

    protected void initVariables() {
    }

    protected void loadData() {
    }

    /**
     * 布局 id
     */
    protected abstract int getLayoutId();

    /**
     * 布局 初始化
     */
    protected abstract void initView();

    /**
     * 获取对应的Binding Impl类
     * Note ： 未使用layout情况下viewDataBinding==null
     */
    protected <VB extends ViewDataBinding> VB getBinding(Class<VB> tClass) {
        return tClass.cast(viewDataBinding);
    }

    /**
     * 获取ViewModel
     */
    protected <T extends ViewModel> T getVM(Class<T> modelClass) {
        if (mViewModelProvider == null) {
            mViewModelProvider = new ViewModelProvider(this);
        }
        return mViewModelProvider.get(modelClass);
    }



    @Override
    protected void onDestroy() {
        try {
            if (viewDataBinding != null) {
                viewDataBinding.unbind();
                viewDataBinding = null;
            }
        } catch (Exception e) {
        }
        super.onDestroy();
    }

}
