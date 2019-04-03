package com.example.kotlindemo.presenter

import android.text.TextUtils

class LoginPresenter(var baseView: MainView?) :BasePresenter<MainView> {
    override fun getView(): MainView {
        return baseView as MainView
    }

    override fun onResume() {

    }

    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {
        baseView = null
    }


    fun login(username: String, userpwd: String) {
        baseView?.showLoading("请求中...")
        if (TextUtils.isEmpty(username)||TextUtils.isEmpty(userpwd)) {
            baseView?.loginFailed("请输入账号和密码")
            baseView?.dismissLoading()
        }else{
            android.os.Handler().postDelayed({
                loginSuccess()
            },2000)
        }

    }

    fun loginSuccess() {
        baseView?.loginSuccess()
    }

}
