package com.example.kotlindemo.presenter

interface MainView: BaseView {
    abstract fun login(username:String,pwd:String)
    abstract fun loginFailed(error:String)
    abstract fun loginSuccess()
    abstract fun showLoading(message:String)
    abstract fun dismissLoading()
}