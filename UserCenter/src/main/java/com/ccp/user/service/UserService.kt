package com.ccp.user.service

import com.ccp.user.data.protocol.UserInfo
import rx.Observable

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
interface UserService {
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<Boolean>

    fun login(mobile:String,pwd:String,pushId:String):Observable<UserInfo>

    fun forgetPwd(mobile:String,verifyCode:String):Observable<Boolean>

    fun resetPwd(mobile:String,pwd:String):Observable<Boolean>
}