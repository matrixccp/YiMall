package com.ccp.base.presenter.view

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}