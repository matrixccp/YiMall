package com.ccp.base.ui.activity

import android.graphics.Color
import android.os.Bundle
import cn.pedant.SweetAlert.SweetAlertDialog
import com.ccp.base.common.BaseApplication
import com.ccp.base.injection.component.ActivityComponent
import com.ccp.base.injection.component.DaggerActivityComponent
import com.ccp.base.injection.module.ActivityModule
import com.ccp.base.injection.module.LifeCycleProviderModule
import com.ccp.base.presenter.BasePresenter
import com.ccp.base.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject



/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
open abstract class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

//    lateinit var mLoadingDialog: ProgressLoading

    lateinit var sweetAlertDialog: SweetAlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
//        mLoadingDialog = ProgressLoading.create(this)
        sweetAlertDialog = SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE)
        sweetAlertDialog.progressHelper.barColor = Color.parseColor("#03a9f4")
        sweetAlertDialog.setCancelable(false)
        sweetAlertDialog.titleText = "拼命加载中"
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }

    override fun showLoading() {
        sweetAlertDialog.show()

    }

    override fun hideLoading() {
        sweetAlertDialog.hide()
    }

    override fun onError(text:String) {
        toast(text)
    }
}