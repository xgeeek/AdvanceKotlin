package com.advance.kotlin.sort_dialog

/**
 * @author xugang
 * @date 2021/12/17
 */
interface DialogInterceptor {
    fun intercept(chain: DialogChain)
}