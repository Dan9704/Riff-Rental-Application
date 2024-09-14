package au.edu.swin.sdmd.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Use ActivityScenarioRule instead of ActivityTestRule
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("au.edu.swin.sdmd.myapplication", appContext.packageName)
    }

    @Test
    fun testSearchBarInput() {
        // Test the search bar input
        onView(withId(R.id.searchBar)).perform(typeText("Guitar"), closeSoftKeyboard())
        onView(withId(R.id.searchBar)).check(matches(withText("Guitar")))
    }

    @Test
    fun testBorrowButtonNavigatesToBorrowActivity() {
        // Test navigation to BorrowActivity
        onView(withId(R.id.buttonBorrow)).perform(click())
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()))
    }

    @Test
    fun testPlaySoundButton() {
        // Test clicking the play sound button
        onView(withId(R.id.buttonPlaySound)).perform(click())
        // Add further checks to validate sound play behavior, if necessary
    }
}
