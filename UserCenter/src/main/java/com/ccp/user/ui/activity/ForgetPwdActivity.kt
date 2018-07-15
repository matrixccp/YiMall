package com.ccp.user.ui.activity

import android.os.Bundle
import android.view.View
import com.ccp.base.ext.enable
import com.ccp.base.ext.onClick
import com.ccp.base.ui.activity.BaseMvpActivity
import com.ccp.user.R
import com.ccp.user.injection.component.DaggerUserComponent
import com.ccp.user.injection.module.UserModule
import com.ccp.user.presenter.ForgetPwdPresenter
import com.ccp.user.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView,View.OnClickListener {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()
    }

    private fun initView() {
        mNextBtn.enable(mMobileEt) {isBtnEnable()}
        mNextBtn.enable(mVerifyCodeEt) {isBtnEnable()}

        mVerifyCodeBtn.onClick(this)
        mNextBtn.onClick(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mRegisterBtn -> {
                mPresenter.forget(mMobileEt.text.toString().trim(), mVerifyCodeEt.text.toString())
            }
        }
    }
    fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }

    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    }
}
