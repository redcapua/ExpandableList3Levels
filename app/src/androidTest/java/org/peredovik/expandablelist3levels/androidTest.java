package org.peredovik.expandablelist3levels;


import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ExpandableListView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class androidTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    Level1And2Adapter l2l3Adapter;
    String[] mGroupsLevel1;
    ArrayList<ArrayList<Map<String, String>>> mGroupsLevel2;
    Map<String, String> mLevel2Bold;
    ExpandableListView expList;



    @Test
    public void verifyFirstGroupExpand() {

        onData(anything()).inAdapterView(withId(R.id.elv01)).atPosition(0).perform(click());

        SystemClock.sleep(5000);

        mainActivityRule.getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run(){

                boolean isExpanded = mainActivityRule.getActivity().expList.isGroupExpanded(0);
                assertEquals(isExpanded, true);

                isExpanded = mainActivityRule.getActivity().expList.isGroupExpanded(1);
                assertEquals(isExpanded, false);

                mainActivityRule.getActivity().expList.collapseGroup(0);

            }
        });

    }

    @Test
    public void verifySecondGroupExpand() {

        onData(anything()).inAdapterView(withId(R.id.elv01)).atPosition(1).perform(click());

        SystemClock.sleep(5000);

        mainActivityRule.getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run(){

                boolean isExpanded = mainActivityRule.getActivity().expList.isGroupExpanded(1);
                assertEquals(isExpanded, true);

                isExpanded = mainActivityRule.getActivity().expList.isGroupExpanded(2);
                assertEquals(isExpanded, false);

                mainActivityRule.getActivity().expList.collapseGroup(1);

            }
        });

    }

//    @Test
//    public void verifySeventhGroupExpand() {
//
//        onData(anything()).inAdapterView(withId(R.id.elv01)).atPosition(1).perform(click());
//
//        SystemClock.sleep(1000);
//
//        onData(anything()).inAdapterView(withId(R.id.elv01)).atPosition(7).perform(click());
//
//        SystemClock.sleep(5000);
//
//        mainActivityRule.getActivity().runOnUiThread(new Runnable(){
//            @Override
//            public void run(){
//
//                boolean isExpanded = mainActivityRule.getActivity().expList.isGroupExpanded(7);
//                assertEquals(isExpanded, false);
//
//            }
//        });
//
//    }



}