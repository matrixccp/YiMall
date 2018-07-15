package com.ccp.user.presenter

import com.ccp.base.ext.execute
import com.ccp.base.presenter.BasePresenter
import com.ccp.base.rx.BaseSubscriber
import com.ccp.user.data.protocol.UserInfo
import com.ccp.user.presenter.view.LoginView
import com.ccp.user.service.UserService
import javax.inject.Inject

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
class LoginPresenter @Inject constructor(): BasePresenter<LoginView>() {

    @Inject
    lateinit var userService:UserService
    fun login(mobile: String, pwd: String, pushId: String) {

        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd,pushId )
                .execute(object :BaseSubscriber<UserInfo>(mView){
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResult(t)
                    }
                },lifecycleProvider)
    }
}