package br.com.timetracking.view.ui.base

import android.annotation.SuppressLint
import android.app.Fragment
import android.view.View
import br.com.timetracking.R
import butterknife.ButterKnife
import butterknife.Unbinder
import java.text.SimpleDateFormat
import java.util.*

open class BaseFragment : Fragment() {

    private var mButterKnifeUnbinder: Unbinder? = null

    /**
     * Bind fragment with Butterknife.
     * @param layout Layout of fragment.
    */
    protected fun bind(layout: View) {
        mButterKnifeUnbinder = ButterKnife.bind(this, layout)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (mButterKnifeUnbinder != null) {
            mButterKnifeUnbinder!!.unbind()
        }
    }

    @SuppressLint("SimpleDateFormat")
    /**
     * Return current date and time in string
    */
    fun getToday(): String {
        val dateFormat = SimpleDateFormat("HH:mm")
        dateFormat.timeZone = TimeZone.getTimeZone(getString(R.string.time_zone))
        return dateFormat.format(Calendar.getInstance().time)
    }
}