package com.ccp.user.presenter

import com.ccp.base.ext.execute
import com.ccp.base.presenter.BasePresenter
import com.ccp.base.rx.BaseSubscriber
import com.ccp.user.presenter.view.RegisterView
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
class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService:UserService
    fun register(mobile: String, pwd: String, verifyCode: String) {

        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.register(mobile, pwd,verifyCode )
                .execute(object :BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult("register success")
                    }
                },lifecycleProvider)
    }
}