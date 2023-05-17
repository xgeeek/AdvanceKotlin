package com.advance.kotlin.fragmentvisible;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.advance.kotlin.R;

/**
 * @author xugang
 * @date 2023/5/17
 */
public abstract class BaseFragment extends Fragment {

    private View rootView;
    protected Context mContext;
    private ViewDataBinding viewDataBinding;
    private ViewModelProvider mViewModelProvider;

    protected boolean hasDataLoaded = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        initVariables();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_base, container, false);
        View childView = getLayoutInflater().inflate(getLayoutId(), null);
        ((ViewGroup) rootView.findViewById(R.id.fl_content)).addView(childView);
        if (childView.getTag() instanceof String) {
            viewDataBinding = DataBindingUtil.bind(childView);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!needLazyLoadData()) {
            loadData(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (needLazyLoadData() && !hasDataLoaded) {
            loadData(true);
            hasDataLoaded = true;
        }
    }

    protected void initVariables() {
    }

    protected boolean needLazyLoadData() {
        return false;
    }

    public View getRootView() {
        return rootView;
    }

    /**
     * 布局 id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化
     */
    protected abstract void loadData(boolean isLazy);

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
}
