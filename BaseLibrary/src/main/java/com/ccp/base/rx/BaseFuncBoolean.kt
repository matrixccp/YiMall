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
class BaseFuncBoolean<T>:Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS ){
            return Observable.error(BaseException(t.status,t.message))
        }
        return Observable.just(true)
    }
}