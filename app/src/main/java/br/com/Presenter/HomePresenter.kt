package br.com.Presenter

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import br.com.timetracking.R
import br.com.timetracking.view.ui.login.LoginActivity

class HomePresenter
/**
 * Class constructor
 *
 * @param activity - Activity
 */
(activity: Activity) : BasePresenter() {

    init {
        mActivity = activity
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    fun pushFragment(fragment: Fragment?) {
        if (fragment == null) {
            return
        }
        val fragmentManager = mActivity?.fragmentManager
        if (fragmentManager != null) {
            val ft = fragmentManager.beginTransaction()
            if (ft != null) {
                ft.replace(R.id.main_container, fragment).commit()
            }
        }
    }

    /**
     * Navigates to LoignActivity
     */
    fun startLoginActivity() {
        val intent = Intent(mActivity, LoginActivity::class.java)
        mActivity?.startActivity(intent)
        mActivity?.finish()
    }
}