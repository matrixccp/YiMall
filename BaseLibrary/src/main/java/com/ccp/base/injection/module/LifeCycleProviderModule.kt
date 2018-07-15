package com.ccp.base.injection.module

import com.ccp.base.injection.ActivityScope
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
@Module
class LifeCycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>){

    @ActivityScope
    @Provides
    fun provideLifecycleProvider():LifecycleProvider<*>{
        return this.lifecycleProvider
    }
}