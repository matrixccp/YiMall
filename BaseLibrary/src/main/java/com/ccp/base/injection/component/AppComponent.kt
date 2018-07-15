package com.ccp.base.injection.component

import android.content.Context
import com.ccp.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context
}