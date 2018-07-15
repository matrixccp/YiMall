package com.ccp.base.injection.module

import android.content.Context
import com.ccp.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
@Module
class AppModule(private val context: BaseApplication){

    @Provides
    @Singleton
    fun providesContext():Context{
        return this.context
    }
}