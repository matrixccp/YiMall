package com.ccp.user.ui.activity

import android.os.Bundle
import android.view.View
import com.ccp.base.ext.enable
import com.ccp.base.ext.onClick
import com.ccp.base.ui.activity.BaseMvpActivity
import com.ccp.user.R
import com.ccp.user.injection.component.DaggerUserComponent
import com.ccp.user.injection.module.UserModule
import com.ccp.user.presenter.ResetPwdPresenter
import com.ccp.user.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.toast

class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView,View.OnClickListener {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onResetPwdResult(result: String) {
        toast(result)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)
        initView()
    }

    private fun initView() {
        mConfirmBtn.enable(mPwdEt) {isBtnEnable()}
        mConfirmBtn.enable(mPwdConfirmEt) {isBtnEnable()}

        mConfirmBtn.onClick(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mConfirmBtn -> {
                mPresenter.resetPwd(mPwdEt.text.toString().trim(), mPwdConfirmEt.text.toString())
            }
        }
    }
    fun isBtnEnable():Boolean{
        return mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
