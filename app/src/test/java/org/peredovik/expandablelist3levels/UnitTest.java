package org.peredovik.expandablelist3levels;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

    @Mock
    private MainActivity mainActivity;

    Level1And2Adapter level2AndLevel3Adapter;

    @Before
    public void Level1And2AdapterPrepare(){

        level2AndLevel3Adapter = new Level1And2Adapter();

    }


    @Test
    public void Level1And2AdapterChildSelectableTrue(){

        boolean resultTrue = level2AndLevel3Adapter.isChildSelectable(1, 1);

        assertTrue(resultTrue);

    }


    @Test
    public void Level1And2AdapterChildHasStableIDSTrue(){

        boolean resultTrue = level2AndLevel3Adapter.hasStableIds();

        assertTrue(resultTrue);

    }


    @Test
    public void Level1And2AdapterGetChildId(){

        int groupPos = 0;
        int childPos = 0;

        long resultLong = level2AndLevel3Adapter.getChildId(groupPos, childPos);

        assertEquals(resultLong, childPos);

    }



}