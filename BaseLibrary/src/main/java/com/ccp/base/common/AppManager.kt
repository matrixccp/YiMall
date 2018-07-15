package com.ccp.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * <p>desc：<p>
 * <p>author：CP<p>
 * <p>create time：2018/7/14<p>
 * <p>change time：2018/7/14<p>
 * <p>version：1<p>
 *
 */
class AppManager private constructor(){

    private val activityStack:Stack<Activity> = Stack()

    companion object {
        val instance:AppManager by lazy { AppManager() }
    }

    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    fun removeActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    fun currentActivity():Activity{
        return activityStack.lastElement()
    }

    fun clearAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }

    fun exiyApp(context: Context){
        clearAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}