package com.ccp.user.ui.activity

import android.os.Bundle
import android.view.View
import com.ccp.base.ext.enable
import com.ccp.base.ext.onClick
import com.ccp.base.ui.activity.BaseMvpActivity
import com.ccp.user.R
import com.ccp.user.data.protocol.UserInfo
import com.ccp.user.injection.component.DaggerUserComponent
import com.ccp.user.injection.module.UserModule
import com.ccp.user.presenter.LoginPresenter
import com.ccp.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onLoginResult(result: UserInfo) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }

        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
        mForgetPwdTv.onClick(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mRightTv -> {startActivity<RegisterActivity>()}
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
            }
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
