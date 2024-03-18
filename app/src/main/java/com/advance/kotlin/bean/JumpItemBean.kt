package com.advance.kotlin.bean

/**
 * @author xugang
 * @date 2024/3/18
 */
data class JumpItemBean(
    val tag: String,
    val childList: MutableList<JumpItemChildBean>,
    var show: Boolean
)

data class JumpItemChildBean(val name: String)