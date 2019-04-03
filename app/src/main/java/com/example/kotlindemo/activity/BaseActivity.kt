package com.example.kotlindemo.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.kotlindemo.presenter.IPresenter

abstract class BaseActivity <T :IPresenter>: AppCompatActivity() {
    fun getContext(): Context {
        return applicationContext;
    }
    abstract fun getPresenter(): T

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().onDestroy()
    }
}