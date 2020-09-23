package com.advance.kotlin.grammar.cOrientedObject

/**
 * 单利
 * @author xugang
 * @date 2020/8/30
 * @since
 */
class Driverm

interface OnExternalDriveMountListener {
    fun onMount(driverm: Driverm)
    fun onUnMount(driverm: Driverm)
}

abstract class Player

// 可以继承和实现
object MusicPlayer : Player(), OnExternalDriveMountListener {
    override fun onMount(driverm: Driverm) {
    }

    override fun onUnMount(driverm: Driverm) {
    }

    val state: Int = 0

    fun play(url: String) {
    }
}
