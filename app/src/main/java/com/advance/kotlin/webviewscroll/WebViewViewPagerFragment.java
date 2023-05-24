package com.advance.kotlin.webviewscroll;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.advance.kotlin.R;

public class WebViewViewPagerFragment extends Fragment {

    private int mPage;
    WebView webView;

    public static WebViewViewPagerFragment create(int page) {
        WebViewViewPagerFragment fragment = new WebViewViewPagerFragment();
        fragment.mPage = page;
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prt_content_webview, null);
        webView = view.findViewById(R.id.web);
        // 开启 localStorage
        webView.getSettings().setDomStorageEnabled(true);
        // 设置支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 启动缓存
        webView.getSettings().setAppCacheEnabled(true);
        // 设置缓存模式
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //使用自定义的WebViewClient
        webView.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://app.qhxfapp.cc/futures/app/small_funds.html");
        return view;
    }

}
