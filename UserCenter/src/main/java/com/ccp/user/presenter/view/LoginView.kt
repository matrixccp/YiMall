package com.ccp.user.presenter.view

import com.ccp.base.presenter.view.BaseView
import com.ccp.user.data.protocol.UserInfo

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
interface LoginView:BaseView {

    fun onLoginResult(result: UserInfo){

    }
}