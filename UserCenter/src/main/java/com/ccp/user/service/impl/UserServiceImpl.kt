package com.ccp.user.service.impl

import com.ccp.base.ext.convert
import com.ccp.base.ext.convertBoolean
import com.ccp.user.data.protocol.UserInfo
import com.ccp.user.data.repository.UserRepository
import com.ccp.user.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return repository.register(mobile,pwd,verifyCode)
                .convertBoolean()
    }

    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile,pwd,pushId)
                .convert()
    }

    override fun forgetPwd(mobile: String,verifyCode: String): Observable<Boolean> {
        return repository.forgetPwd(mobile,verifyCode)
                .convertBoolean()
    }

    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return repository.resetPwd(mobile,pwd)
                .convertBoolean()
    }
}