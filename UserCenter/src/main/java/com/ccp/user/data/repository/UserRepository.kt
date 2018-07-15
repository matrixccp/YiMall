package com.ccp.user.data.repository

import com.ccp.base.data.net.RetrofitFactory
import com.ccp.base.data.protocal.BaseResp
import com.ccp.user.data.api.UserApi
import com.ccp.user.data.protocol.*
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
class UserRepository @Inject constructor(){
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile,pwd,verifyCode))
    }

    fun login(mobile:String,pwd:String,pushId:String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginReq(mobile,pwd,pushId))
    }

    fun forgetPwd(mobile:String,verifyCode:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .forgetPwd(ForgetPwdReq(mobile,verifyCode))
    }

    fun resetPwd(mobile:String,pwd:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .resetPwd(ResetPwdReq(mobile,pwd))
    }
}