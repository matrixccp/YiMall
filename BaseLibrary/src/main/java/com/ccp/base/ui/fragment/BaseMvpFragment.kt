package com.ccp.base.ui.fragment

import android.os.Bundle
import com.ccp.base.common.BaseApplication
import com.ccp.base.injection.component.ActivityComponent
import com.ccp.base.injection.component.DaggerActivityComponent
import com.ccp.base.injection.module.ActivityModule
import com.ccp.base.injection.module.LifeCycleProviderModule
import com.ccp.base.presenter.BasePresenter
import com.ccp.base.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
open abstract class BaseMvpFragment<T:BasePresenter<*>>:BaseFragment(),BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError(text:String) {
        toast(text)
    }
}