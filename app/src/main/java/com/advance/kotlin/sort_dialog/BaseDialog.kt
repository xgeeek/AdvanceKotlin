package com.advance.kotlin.sort_dialog

import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AlertDialog

/**
 * @author xugang
 * @date 2021/12/20
 */
abstract class BaseDialog(context: Context) : AlertDialog(context), DialogInterceptor {

    private var mChain: DialogChain? = null

    fun chain(): DialogChain? = mChain

    @CallSuper
    override fun intercept(chain: DialogChain) {
        mChain = chain // 保存，提供方法供子类访问
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.attributes?.width = 800
        window?.attributes?.height = 900
    }
}