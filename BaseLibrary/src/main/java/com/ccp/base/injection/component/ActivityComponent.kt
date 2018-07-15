package com.ccp.base.injection.component

import android.app.Activity
import android.content.Context
import com.ccp.base.injection.ActivityScope
import com.ccp.base.injection.module.ActivityModule
import com.ccp.base.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifeCycleProviderModule::class))
interface ActivityComponent {

    fun activity():Activity
    fun context():Context
    fun lifeCycleProvider(): LifecycleProvider<*>
}