package com.advance.kotlin.sort_dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import com.advance.kotlin.R

/**
 * @author xugang
 * @date 2021/12/20
 */
class CDialog(context: Context) : BaseDialog(context), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_c)
        findViewById<View>(R.id.tv_confirm)?.setOnClickListener(this)
        findViewById<View>(R.id.tv_cancel)?.setOnClickListener(this)
        // 弹窗消失时把请求移交给下一个拦截器。
        setOnDismissListener {
            chain()?.process()
        }
    }

    override fun onClick(p0: View?) {
        dismiss()
    }

    override fun intercept(chain: DialogChain) {
        super.intercept(chain)
        val isShow = true // 这里可根据实际业务场景来定制dialog 显示条件。
        if (isShow) {
            this.show()
        } else { // 当自己不具备弹出条件的时候，可以立刻把请求转交给下一个拦截器。
            chain.process()
        }
    }

}