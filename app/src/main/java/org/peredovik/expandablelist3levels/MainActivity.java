package org.peredovik.expandablelist3levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int lenGroup;
	private ExpandableListView expList;
	String[] groupsLevel1 = new String[] {"Messaging", "Projects", "Human Resources", "", "Feedback", "Synchronization", "About", "Logout", ""};
	String[] groupsLevel21 = new String[] {"Messaging", "Inbox", "To: me", "To-do", "Archives", "Organizer", "Calendar", "My groups", "Join a group"};
	String[] groupsLevel22 = new String[] {"Project1", "Project2", "Project3"};
	String[] groupsLevel23 = new String[] {"Top managers", "Ivanov", "Petrov", "Programmers", "Sidorov", "Drivers", "Petya V.", "Vasya K."};
	Map<String, String> groupLevel2;
	ArrayList<Map<String, String>> groupLevel1Data;
	ArrayList<ArrayList<Map<String, String>>> groupLevel2Data;
	Map<String, String> m;
	Level1And2Adapter adapter2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		expList = (ExpandableListView) findViewById(R.id.elv01);  

		groupLevel2 = new HashMap<String, String>();
		groupLevel2.put("g0i0", "1");
		groupLevel2.put("g0i5", "1");
		groupLevel2.put("g0i7", "1");
		groupLevel2.put("g2i0", "1");
		groupLevel2.put("g2i3", "1");
		groupLevel2.put("g2i5", "1");
		
		ArrayList<Map<String, String>> groupLevel2DataItems1;
		ArrayList<Map<String, String>> groupLevel2DataItems2;
		ArrayList<Map<String, String>> groupLevel2DataItems3;
		ArrayList<Map<String, String>> groupLevel2DataItems4;
		ArrayList<Map<String, String>> groupLevel2DataItems5;
		ArrayList<Map<String, String>> groupLevel2DataItems6;
		ArrayList<Map<String, String>> groupLevel2DataItems7;
		ArrayList<Map<String, String>> groupLevel2DataItems8;
		ArrayList<Map<String, String>> groupLevel2DataItems9;

		groupLevel1Data = new ArrayList<Map<String, String>>();
        for (String group : groupsLevel1) {
        	m = new HashMap<String, String>();
            m.put("groupLevel1Name", group);
            groupLevel1Data.add(m);  
        }

        lenGroup = groupLevel1Data.size();
        
        groupLevel2Data = new ArrayList<ArrayList<Map<String, String>>>(); 
        groupLevel2DataItems1 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems2 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems3 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems4 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems5 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems6 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems7 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems8 = new ArrayList<Map<String, String>>();
        groupLevel2DataItems9 = new ArrayList<Map<String, String>>();
        
        for (String groupDataItem : groupsLevel21) {
        	m = new HashMap<String, String>();
            m.put("dataItemsLevel2", groupDataItem);
            groupLevel2DataItems1.add(m);  
        }

        groupLevel2Data.add(groupLevel2DataItems1);        
        
        for (String groupDataItem : groupsLevel22) {
            m = new HashMap<String, String>();
            m.put("dataItemsLevel2", groupDataItem);
            groupLevel2DataItems2.add(m);  
          }

        groupLevel2Data.add(groupLevel2DataItems2);        

        for (String groupDataItem : groupsLevel23) {
            m = new HashMap<String, String>();
            m.put("dataItemsLevel2", groupDataItem);
            groupLevel2DataItems3.add(m);  
          }

        groupLevel2Data.add(groupLevel2DataItems3);        
        groupLevel2Data.add(groupLevel2DataItems4);        
        groupLevel2Data.add(groupLevel2DataItems5);        
        groupLevel2Data.add(groupLevel2DataItems6);        
        groupLevel2Data.add(groupLevel2DataItems7);        
        groupLevel2Data.add(groupLevel2DataItems8);        
        groupLevel2Data.add(groupLevel2DataItems9);        

        adapter2 = new Level1And2Adapter(getApplicationContext(), groupsLevel1, groupLevel2Data, groupLevel2);
        expList.setAdapter(adapter2);       

        expList.setOnGroupExpandListener(new OnGroupExpandListener() {
            
        	public void onGroupExpand(int groupPosition) {

        		for (int i = 0; i < lenGroup; i++) {
                	if (i != groupPosition) {
                		expList.collapseGroup(i);
                	}
            	}

        	}
        });
        
	}

}
