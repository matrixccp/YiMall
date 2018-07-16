# YiMall


## 应用整体架构：Mvp+RxKotlin+RxLifeCycle+ARouter+RxBus+Retorfit+OkHttp3+Anko+Dagger2


1.分模块开发:将各大模块单独抽取module,降低各个模块之间的耦合度便于后期维护

2.使用ARouter跨模块页面跳转,模块间解耦,拦截跳转过程,处理登陆、埋点等逻辑,跨模块API调用,通过控制反转来做组件解耦

3.使用Dagger2来解耦,解耦,解耦,重要的事情说三遍!

    ### 注入
    @PerComponentScope
    @Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
    interface UserComponent {
        fun inject(activity:RegisterActivity)
        fun inject(activity: LoginActivity)
        fun inject(activity: ForgetPwdActivity)
        fun inject(activity: ResetPwdActivity)
    }
    
    ### Activity
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

## 使用anko框架 让你的代码简洁到极致

    toast("hello anko")
    
    startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    
## Thanks to the open source project

* [RxJava](https://github.com/ReactiveX/RxJava)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [RxBinding](https://github.com/JakeWharton/RxBinding)
* [RxLifecycle](https://github.com/trello/RxLifecycle)
* [okhttp](https://github.com/square/okhttp)
* [dagger](https://github.com/square/dagger)
* [retrofit](https://github.com/square/retrofit)
* [BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
* [glide](https://github.com/bumptech/glide)
* [MaterialSearchView](https://github.com/MiguelCatalan/MaterialSearchView)
* [FlycoTabLayout](https://github.com/H07000223/FlycoTabLayout)
* [FlowLayout](https://github.com/hongyangAndroid/FlowLayout)
    
    
    
## License

Copyright 2017 matrixccp

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
