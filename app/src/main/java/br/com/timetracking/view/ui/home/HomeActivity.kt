package br.com.timetracking.view.ui.home

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import br.com.Presenter.HomePresenter
import br.com.timetracking.R
import br.com.timetracking.view.ui.base.BaseActivity
import br.com.timetracking.view.ui.home.fragments.MarkTimeFragment
import br.com.timetracking.view.ui.home.fragments.HoursPointedFragment
import butterknife.BindView

class HomeActivity : BaseActivity() {

    //region [ ButterKnife ]
    @BindView(R.id.navigation) @Nullable @JvmField var mNavigation: BottomNavigationView? = null
    @BindView(R.id.toolbar) @Nullable @JvmField var toolbar: Toolbar? = null
    //endregion

    private var mHomePresenter: HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
        }
        init()
    }

    override fun onBackPressed() {}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun init() {
        mHomePresenter = HomePresenter(this)
        mNavigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mHomePresenter?.pushFragment(MarkTimeFragment())
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_mark_time -> mHomePresenter?.pushFragment(MarkTimeFragment())
            R.id.navigation_hours_pointed -> mHomePresenter?.pushFragment(HoursPointedFragment())
            else -> mHomePresenter?.pushFragment(MarkTimeFragment())
        }
        true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.navigation_exit) {
            mHomePresenter?.startLoginActivity()
        }
        return true
    }
}