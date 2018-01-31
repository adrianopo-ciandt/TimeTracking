package br.com.timetracking.view.ui.login

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.annotation.Nullable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import br.com.Presenter.LoginPresenter
import br.com.timetracking.R
import br.com.timetracking.view.ui.base.BaseActivity
import butterknife.BindView
import butterknife.OnClick

class LoginActivity : BaseActivity() {

    //region [ ButterKnife ]
    @BindView(R.id.etName) @Nullable @JvmField var etName: EditText? = null
    @BindView(R.id.etPass)  @Nullable @JvmField var etPass: EditText? = null
    @BindView(R.id.btnLogin) @Nullable @JvmField var btnLogin: Button? = null
    //endregion

    private var mLoginPresenter: LoginPresenter? = null

    var NAME = "name"
    var PASS = "pass"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun init() {
        mLoginPresenter = LoginPresenter(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        }
        etName?.setText(prefs?.getString(NAME, EMPTY))
        etPass?.setText(prefs?.getString(PASS, EMPTY))
        enableBtnLogin()
        etPass?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                if (etName?.text.toString() != EMPTY && !s.isNullOrEmpty()){
                    btnLogin?.visibility = View.VISIBLE
                } else {
                    btnLogin?.visibility = View.GONE
                }
            }
        })
        etName?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                if (etName?.text.toString() != EMPTY && etPass?.text.toString() != EMPTY){
                    btnLogin?.visibility = View.VISIBLE
                } else {
                    etPass?.setText(EMPTY)
                    btnLogin?.visibility = View.GONE
                }
            }
        })
    }

    private fun enableBtnLogin() {
        if (etName?.text.toString() == EMPTY && etPass?.text.toString() == EMPTY) {
            btnLogin?.visibility = View.GONE
        } else {
            btnLogin?.visibility = View.VISIBLE
        }
    }

    @OnClick(R.id.btnLogin)
    fun btnLoginClick(){
        val hasMap = HashMap<String, String>()
        hasMap.put(NAME, etName?.text.toString())
        hasMap.put(PASS, etPass?.text.toString())
        mLoginPresenter?.saveShared(prefs, hasMap)
    }
}
