package com.ccp.base.data.protocal

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
class BaseResp<out T>(val status:Int, val message:String, val data:T) {

}