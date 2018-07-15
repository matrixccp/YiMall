package com.ccp.base.rx

import com.ccp.base.common.ResultCode
import com.ccp.base.data.protocal.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
class BaseFunc<T>:Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS ){
            return Observable.error(BaseException(t.status,t.message))
        }
        return Observable.just(t.data)
    }
}