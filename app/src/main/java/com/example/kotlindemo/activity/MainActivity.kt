package com.example.kotlindemo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.kotlindemo.R
import com.example.kotlindemo.presenter.LoginPresenter
import com.example.kotlindemo.presenter.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<LoginPresenter>(),MainView {

    var mPresenter:LoginPresenter = getPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloBtn.setOnClickListener {
            showLoading("请求中...")
            login(accountEt.text.toString(),pwdEt.text.toString())
        }
    }

    override fun login(username: String, pwd: String) {
        mPresenter.login(username,pwdEt.text.toString())
    }

    override fun getPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun showLoading(message:String) {
        progressBar.show()

    }

    override fun loginFailed(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun loginSuccess() {
        dismissLoading()
        Toast.makeText(applicationContext,"登录成功",Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,LoginSuccessActivity::class.java))
    }

    override fun dismissLoading() {
        progressBar.hide()
    }
}
