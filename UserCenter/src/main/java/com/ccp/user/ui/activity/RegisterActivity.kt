package com.ccp.user.ui.activity

import android.os.Bundle
import android.view.View
import com.ccp.base.common.AppManager
import com.ccp.base.ext.enable
import com.ccp.base.ext.onClick
import com.ccp.base.ui.activity.BaseMvpActivity
import com.ccp.user.R
import com.ccp.user.injection.component.DaggerUserComponent
import com.ccp.user.injection.module.UserModule
import com.ccp.user.presenter.RegisterPresenter
import com.ccp.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView,View.OnClickListener {

    private var pressTime: Long = 0

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt) {isBtnEnable()}
        mRegisterBtn.enable(mVerifyCodeEt) {isBtnEnable()}
        mRegisterBtn.enable(mPwdEt) {isBtnEnable()}
        mRegisterBtn.enable(mPwdConfirmEt) {isBtnEnable()}

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("double click exit")
            pressTime = time
        } else {
            AppManager.instance.clearAllActivity()
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("验证码已发送，请查收")
            }
            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString().trim(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString())
            }
        }
    }
    fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeBtn.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
