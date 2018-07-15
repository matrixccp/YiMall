package com.ccp.user.data.api

import com.ccp.base.data.protocal.BaseResp
import com.ccp.user.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq):Observable<BaseResp<String>>

    @POST("userCenter/login")
    fun login(@Body req:LoginReq):Observable<BaseResp<UserInfo>>

    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req:ForgetPwdReq):Observable<BaseResp<String>>

    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req:ResetPwdReq):Observable<BaseResp<String>>
}