package com.jmgarzo.newratescar;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.google.common.base.Preconditions.checkArgument;
import static org.hamcrest.Matchers.allOf;


/**
 * Created by jmgarzo on 08/01/2017.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class VehicleTest {


    private Matcher<View> withItemText(final String itemText) {
        checkArgument(!TextUtils.isEmpty(itemText), "itemText cannot be null or empty");
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View item) {
                return allOf(
                        isDescendantOfA(isAssignableFrom(RecyclerView.class)),
                        withText(itemText)).matches(item);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("is isDescendantOfA RV with text " + itemText);
            }
        };
    }


/*    @Test
    public void clickAddNoteButton_opensAddNoteUi() throws Exception {
        // Click on the add note button
        onView(withId(R.id.fab_vehicles)).perform(click());

        // Check if the add note screen is displayed
        onView(withId(R.id.add_note_title)).check(matches(isDisplayed()));
    }*/

    @Rule
    public ActivityTestRule<VehiclesActivity> mVehiclesActivityTestRule =
            new ActivityTestRule<VehiclesActivity>(VehiclesActivity.class);

    @Test
    public void addVehicle() throws Exception {

        String vehicleName="CarTest01";

        onView(withId(R.id.fab_vehicles)).perform(click());

        onView(withId(R.id.input_vehicle_name)).perform(typeText(vehicleName), closeSoftKeyboard());

        onView(withId(R.id.action_done_vehicle)).perform(click());

        onView(withId(R.id.recyclerview_vehicles)).perform(
                scrollTo(hasDescendant(withText(vehicleName))));

        onView(withItemText(vehicleName)).check(matches(isDisplayed()));
    }



}
