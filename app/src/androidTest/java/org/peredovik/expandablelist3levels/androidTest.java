package org.peredovik.expandablelist3levels;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


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

    @Before
    public void Level1And2AdapterPrepare(){

        Context applicationContext = mainActivityRule.getActivity().getApplicationContext();

        mGroupsLevel1 = mainActivityRule.getActivity().groupsLevel1;
        mGroupsLevel2 = mainActivityRule.getActivity().groupLevel2Data;
        mLevel2Bold = mainActivityRule.getActivity().groupLevel2;

        l2l3Adapter = new Level1And2Adapter(applicationContext, mGroupsLevel1, mGroupsLevel2, mLevel2Bold);

    }

    @Test
    public void TargetContext(){

        Context appContext = InstrumentationRegistry.getTargetContext();

        Assert.assertEquals("org.peredovik.expandablelist3levels", appContext.getPackageName());

    }

    @Test
    public void Level1And2AdapterSimpleCreatedProperly() {

        MainActivity mainActivity = mainActivityRule.getActivity();

        Level1And2Adapter l2l3Adapter = mainActivity.adapter2;

        assertNotNull(l2l3Adapter);

    }


    @Test
    public void Level1And2AdapterCreatedProperly() {

        assertNotNull(l2l3Adapter);

    }

    @Test
    public void Level1And2AdapterCorrectGroupsCount() {

        assertEquals(mGroupsLevel1.length, l2l3Adapter.getGroupCount());

    }


    @Test
    public void Level1And2AdapterExpandListener() throws Exception{

        expList = mainActivityRule.getActivity().expList;


        mainActivityRule.getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run(){

                expList = mainActivityRule.getActivity().expList;
                expList.expandGroup(0);

                boolean isExpanded = expList.isGroupExpanded(0);
                boolean isExpandedFalse = expList.isGroupExpanded(1);

                assertEquals(isExpanded, true);
                assertEquals(isExpandedFalse, false);

            }
        });

    }


    @Test
    public void Level1And2AdapterGetGroupValue(){

        String groupName = mGroupsLevel1[0];

        assertEquals(l2l3Adapter.getGroup(0), groupName);

    }


    @Test
    public void Level1And2AdapterGetChildValue(){

        Map<String, String> childItem = mGroupsLevel2.get(0).get(0);
        String childName = childItem.get("dataItemsLevel2");

        Map<String, String> childItem1 = (Map<String, String>)l2l3Adapter.getChild(0, 0);
        String childName1 = childItem1.get("dataItemsLevel2");

        assertEquals(childName1, childName);

    }

}