package br.com.Presenter

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import br.com.timetracking.view.ui.home.HomeActivity

class LoginPresenter
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
     * Navigates to HomeActivity
     */
    fun startSettingsActivity() {
        val intent = Intent(mActivity, HomeActivity::class.java)
        mActivity?.startActivity(intent)
    }

    fun saveShared(prefs : SharedPreferences?, hasMap: HashMap<String, String>) {
        val editor = prefs?.edit()
        for ((v,k) in hasMap.entries){
            println("$v -> $k")
            editor?.putString(v, k)
        }
        editor?.apply()
        startSettingsActivity()
    }
}