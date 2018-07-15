# YiMall


## 应用整体架构：Mvp+RxKotlin+RxLifeCycle+ARouter+RxBus+Retorfit+OkHttp3+Anko+Dagger2


### 1.分模块开发:将各大模块单独抽取module,降低各个模块之间的耦合度便于后期维护

### 2.使用ARouter跨模块页面跳转,模块间解耦,拦截跳转过程,处理登陆、埋点等逻辑,跨模块API调用,通过控制反转来做组件解耦

### 3.使用Dagger2来解耦,解耦,解耦,重要的事情说三遍!
    ```java
    @PerComponentScope
    @Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
    interface UserComponent {
    fun inject(activity:RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    }
    
    ### Activity自动初始化
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
    ```

### 使用anko框架 让你的代码简洁到极致
    ```java
    toast("hello anko")
    
    startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    ```


