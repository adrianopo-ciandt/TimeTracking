package br.com.timetracking.app.robots

import android.app.Activity
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.GeneralLocation
import android.support.test.espresso.action.GeneralSwipeAction
import android.support.test.espresso.action.Press
import android.support.test.espresso.action.Swipe
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import android.view.ViewGroup
import com.squareup.spoon.Spoon
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.StringEndsWith.endsWith

open class BaseRobot {

    fun takeScreenshot(activity: Activity, description: String) {
        Spoon.screenshot(activity, description)
    }

    companion object {

        fun waitFor(millis: Long): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return isRoot()
                }

                override fun getDescription(): String {
                    return "Wait for $millis milliseconds."
                }

                override fun perform(uiController: UiController, view: View) {
                    uiController.loopMainThreadForAtLeast(millis)
                }
            }
        }

        fun swipeLeft(): ViewAction {
            return GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER_RIGHT,
                    GeneralLocation.CENTER_LEFT, Press.FINGER)
        }


        fun assertTextAtScreen(text: String) {
            onView(allOf<View>(withClassName(endsWith("TextView")), withText(`is`<String>(text))))
                    .check(matches(isDisplayed()))
        }

        fun childAtPosition(
                parentMatcher: Matcher<View>, position: Int): Matcher<View> {

            return object : TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("Child at position $position in parent ")
                    parentMatcher.describeTo(description)
                }

                public override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return (parent is ViewGroup && parentMatcher.matches(parent)
                            && view == parent.getChildAt(position))
                }
            }
        }
    }
}