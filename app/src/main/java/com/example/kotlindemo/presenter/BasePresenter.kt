package com.example.kotlindemo.presenter

/**
 * @author hezd
 */
interface BasePresenter<T : BaseView>: IPresenter {

    fun getView():T

}