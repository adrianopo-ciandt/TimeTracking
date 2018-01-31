package br.com.timetracking.view.ui.base

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    var EMPTY = ""
    var prefs: SharedPreferences? = null
    private var myPreferences = "br.com.timetracking"

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        initButterKnife()
        initShared()
    }

    override fun setContentView(view: View) {
        super.setContentView(view)
        initButterKnife()
        initShared()
    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        super.setContentView(view, params)
        initButterKnife()
        initShared()
    }

    /**
     * Realiza o bind da activity atual no ButterKnife
     */
    private fun initButterKnife() {
        ButterKnife.bind(this)
    }

    /**
     * Realizes o SharedPreferences
     */
    private fun initShared() {
        prefs = getSharedPreferences(myPreferences, AppCompatActivity.MODE_PRIVATE)
    }
}
