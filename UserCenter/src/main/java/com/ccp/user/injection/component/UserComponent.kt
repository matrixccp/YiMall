package com.ccp.user.injection.component

import com.ccp.base.injection.component.ActivityComponent
import com.ccp.base.injection.component.PerComponentScope
import com.ccp.user.injection.module.UserModule
import com.ccp.user.ui.activity.ForgetPwdActivity
import com.ccp.user.ui.activity.LoginActivity
import com.ccp.user.ui.activity.RegisterActivity
import com.ccp.user.ui.activity.ResetPwdActivity
import dagger.Component

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
}