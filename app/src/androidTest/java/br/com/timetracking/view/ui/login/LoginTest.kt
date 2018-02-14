package br.com.timetracking.view.ui.login

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.timetracking.BaseData
import br.com.timetracking.app.robots.LoginRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.microsoft.appcenter.espresso.Factory
import org.junit.After




@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Rule
    var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)
    @Rule
    var reportHelper = Factory.getReportHelper()

    @After
    fun TearDown() {
        reportHelper.label("Stopping App")
    }

    @Test
    fun loginSuccess() {
        val base = BaseData()
        val robot = LoginRobot()
        robot.openLogIn()
             .clear()
             .email(base.EMAIL)
             .password(base.PASSWORD)
    }
}