package com.ccp.base.presenter

import android.content.Context
import com.ccp.base.presenter.view.BaseView
import com.ccp.base.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */

open class BasePresenter<T:BaseView> {
    lateinit var mView:T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork():Boolean{
        if (NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络开小差了")
        return false
    }
}