package org.peredovik.expandablelist3levels;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class androidTest {

//    private MainActivity mainActivity;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void addition_isCorrect(){

        Context appContext = InstrumentationRegistry.getTargetContext();

        Assert.assertEquals("org.peredovik.expandablelist3levels", appContext.getPackageName());


    }

    @Test
    public void Level1And2AdapterChildCreatedProperly() {

        MainActivity mainActivityA = mainActivityRule.getActivity();

        Level1And2Adapter l2l3Adapter = mainActivityA.adapter2;

        assertNotNull(l2l3Adapter);

    }


}