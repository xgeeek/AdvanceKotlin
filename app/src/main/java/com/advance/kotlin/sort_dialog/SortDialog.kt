package com.advance.kotlin.sort_dialog

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * @author xugang
 * @date 2021/12/17
 */

class DialogChain(
    val activity: FragmentActivity? = null,
    val fragment: Fragment? = null,
    private var interceptors: MutableList<DialogInterceptor>?
) {
    companion object {
        @JvmStatic
        fun create(initialCapacity: Int = 0): Builder {
            return Builder(initialCapacity)
        }
    }

    private var index: Int = 0

    // 执行拦截器
    fun process() {
        interceptors ?: return
        when (index) {
            in interceptors!!.indices -> {
                val interceptor = interceptors!![index]
                index++
                interceptor.intercept(this)
            }
            // 最后一个弹窗关闭的时候，我们希望释放所有弹窗引用。
            interceptors!!.size -> {
                Log.d("sortDialog", "===> clearAllInterceptors")
                clearAllInterceptors()
            }
        }
    }

    private fun clearAllInterceptors() {
        interceptors?.clear()
        interceptors = null
    }

}

open class Builder(private val initialCapacity: Int = 0) {
    private val interceptors by lazy(LazyThreadSafetyMode.NONE) {
        ArrayList<DialogInterceptor>(
            initialCapacity
        )
    }

    private var activity: FragmentActivity? = null
    private var fragment: Fragment? = null

    // 添加一个拦截器。
    fun addInterceptor(interceptor: DialogInterceptor): Builder {
        if (!interceptors.contains(interceptor)) {
            interceptors.add(interceptor)
        }
        return this
    }

    // 关联Fragment。
    fun attach(fragment: Fragment): Builder {
        this.fragment = fragment
        return this
    }

    // 关联Activity。
    fun attach(activity: FragmentActivity): Builder {
        this.activity = activity
        return this
    }


    fun build(): DialogChain {
        return DialogChain(activity, fragment, interceptors)
    }

}