package com.ccp.base.injection.module

import android.app.Activity
import com.ccp.base.injection.ActivityScope
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
class ActivityModule(private val activity: Activity){

    @ActivityScope
    @Provides
    fun provideActivity():Activity{
        return this.activity
    }
}