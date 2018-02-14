package br.com.timetracking.app.robots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import br.com.timetracking.R

abstract class BaseLoginRobot : BaseRobot() {

    fun email(email: String): BaseLoginRobot {
        onView(withId(R.id.etName))
                .perform(replaceText(email), closeSoftKeyboard())
        return this
    }

    fun password(password: String): BaseLoginRobot {
        onView(withId(R.id.etPass))
                .perform(replaceText(password), closeSoftKeyboard())
        return this
    }

    fun clear(): BaseLoginRobot {
        onView(withId(R.id.etName))
                .perform(replaceText(""), closeSoftKeyboard())
        onView(withId(R.id.etPass))
                .perform(replaceText(""), closeSoftKeyboard())
        return this
    }

    fun openLogIn(): BaseLoginRobot {
        onView(withId(R.id.btnLogin)).perform(click())
        return this
    }
}