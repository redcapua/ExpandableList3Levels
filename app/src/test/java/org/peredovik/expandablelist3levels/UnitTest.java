package org.peredovik.expandablelist3levels;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

    @Mock
    private MainActivity mainActivity;

    @Test
    public void addition_isCorrect(){
        assertEquals(4, 2 + 2);


    }


    @Test
    public void Level1And2AdapterChildSelectableTrue(){

        Level1And2Adapter level2AndLevel3Adapter = new Level1And2Adapter();

        boolean resultTrue = level2AndLevel3Adapter.isChildSelectable(1, 1);

        assertTrue(resultTrue);

    }


    @Test
    public void Level1And2AdapterChildHasStableIDSTrue(){

        Level1And2Adapter level2AndLevel3Adapter = new Level1And2Adapter();

        boolean resultTrue = level2AndLevel3Adapter.hasStableIds();

        assertTrue(resultTrue);

    }



}