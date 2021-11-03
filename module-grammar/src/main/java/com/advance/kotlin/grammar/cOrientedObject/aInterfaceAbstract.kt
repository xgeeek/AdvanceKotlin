package com.advance.kotlin.grammar.cOrientedObject

/**
 * 接口/抽象类
 * 接口的多实现
 * 类的单继承
 * 都可定义抽象方法 由实现者具体实现
 * @author xugang
 * @date 2020/8/29
 * @since
 */
interface InputDevice {  // 只有一个抽象方法的接口成为函数式接口或SAM(单一抽象方法)
    fun input()
}

// 接口的继承
interface UsbInputDevice : InputDevice

interface BleInputDevice : InputDevice


abstract class UsbMouse(mouseName: String) : UsbInputDevice, BleInputDevice {
    override fun input() {
    }
}

// 抽象类的继承
class XiaomiMouse : UsbMouse("xiaomi") {

}

// 接口当参数使用  多态性
class Computer {

    fun addUSBInputDevice(inputDevice: UsbInputDevice) {
        println("add usb input device $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BleInputDevice) {
        println("add ble input device $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is UsbInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            is BleInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("不支持设备类型")
            }
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = XiaomiMouse()
    computer.addInputDevice(mouse)
}