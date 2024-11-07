package com.advance.kotlin.bean

/**
 * @author xugang
 * @date 2024/9/3
 */
data class MultiItemBean(
    val name: String,
    val childList: MutableList<MultiItemChildBean>,
    var show: Boolean,
    var desc:String
)