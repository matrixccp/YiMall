package com.ccp.user.injection.module

import com.ccp.user.service.UserService
import com.ccp.user.service.impl.UserServiceImpl
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
class UserModule {

    @Provides
    fun providesUserServoce(service: UserServiceImpl):UserService{
        return service
    }
}