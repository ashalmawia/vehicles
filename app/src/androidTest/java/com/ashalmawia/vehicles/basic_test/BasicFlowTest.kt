package com.ashalmawia.vehicles.basic_test

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import com.ashalmawia.vehicles.R
import com.ashalmawia.vehicles.features.SingleActivity
import com.ashalmawia.vehicles.features.list.VehicleViewHolder
import org.junit.Test

@LargeTest
class BasicFlowTest {

    val activityRule = ActivityTestRule(SingleActivity::class.java)

    @Test
    fun checkHappyPassHasNoCrashes() {
        // given
        activityRule.launchActivity(Intent())

        // when
        onView(withId(R.id.list)).perform(
            actionOnItemAtPosition<VehicleViewHolder>(1, click())
        )

        // then
        onView(withId(R.id.labelId)).check(matches(isDisplayed()))
        onView(withId(R.id.labelId)).check(matches(withText("2")))
    }
}