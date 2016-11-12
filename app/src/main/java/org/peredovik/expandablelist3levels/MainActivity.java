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

	String TAG = "levels";
	private int lenGroup;
	private ExpandableListView expList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		expList = (ExpandableListView) findViewById(R.id.elv01);  
		
		String[] groupsLevel1 = new String[] {"Messaging", "Projects", "Human Resources", "", "Feedback", "Synchronization", "About", "Logout", ""};
		String[] groupsLevel21 = new String[] {"Messaging", "Inbox", "To: me", "To-do", "Archives", "Organizer", "Calendar", "My groups", "Join a group"};
		String[] groupsLevel22 = new String[] {"Project1", "Project2", "Project3"};
		String[] groupsLevel23 = new String[] {"Top managers", "Ivanov", "Petrov", "Programmers", "Sidorov", "Drivers", "Petya V.", "Vasya K."};

		Map<String, String> groupLevel2;
		groupLevel2 = new HashMap<String, String>();
		groupLevel2.put("g0i0", "1");
		groupLevel2.put("g0i5", "1");
		groupLevel2.put("g0i7", "1");
		groupLevel2.put("g2i0", "1");
		groupLevel2.put("g2i3", "1");
		groupLevel2.put("g2i5", "1");
		
		ArrayList<Map<String, String>> groupLevel1Data;
		  
		ArrayList<Map<String, String>> groupLevel2DataItems1;
		ArrayList<Map<String, String>> groupLevel2DataItems2;
		ArrayList<Map<String, String>> groupLevel2DataItems3;
		ArrayList<Map<String, String>> groupLevel2DataItems4;
		ArrayList<Map<String, String>> groupLevel2DataItems5;
		ArrayList<Map<String, String>> groupLevel2DataItems6;
		ArrayList<Map<String, String>> groupLevel2DataItems7;
		ArrayList<Map<String, String>> groupLevel2DataItems8;
		ArrayList<Map<String, String>> groupLevel2DataItems9;
		
		ArrayList<ArrayList<Map<String, String>>> groupLevel2Data;
		
		Map<String, String> m;

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

        Level1And2Adapter adapter2 = new Level1And2Adapter(getApplicationContext(), groupsLevel1, groupLevel2Data, groupLevel2);
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
	
	public class Level1And2Adapter extends BaseExpandableListAdapter {

		private String[] mGroupsLevel1; 
		private ArrayList<ArrayList<Map<String, String>>> mGroupsLevel2;
	    private Context mContext;
		private Map<String, String> mLevel2Bold;

		public Level1And2Adapter (Context context, String[] groupsLevel1, ArrayList<ArrayList<Map<String, String>>> groupsLevel2, Map<String, String> groupLevel2){
	        mContext = context;
	        mGroupsLevel1 = groupsLevel1;
	        mGroupsLevel2 = groupsLevel2;
	        mLevel2Bold = groupLevel2;
	    }
		
		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
						
			return mGroupsLevel1.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			
			return mGroupsLevel2.get(groupPosition).size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return mGroupsLevel1[groupPosition];
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return mGroupsLevel2.get(groupPosition).get(childPosition);
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if (mGroupsLevel1[groupPosition].length() > 0){
				convertView = inflater.inflate(R.layout.groupt1, null);
		        TextView textGroup = (TextView) convertView.findViewById(R.id.groupname);
		        textGroup.setText(mGroupsLevel1[groupPosition]);
			}else{
				convertView = inflater.inflate(R.layout.groupt2, null);
			}
	        
			return convertView;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			TextView textGroup;
			
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			String sKey;
			sKey = "g" + String.valueOf(groupPosition) + "i" + String.valueOf(childPosition);
			
			if (mLevel2Bold.get(sKey) == null){
		        convertView = inflater.inflate(R.layout.itemg2t1, null);
		        textGroup = (TextView) convertView.findViewById(R.id.groupt1l2name);
		        
		        //check for mail type
		        if (mGroupsLevel2.get(groupPosition).get(childPosition).get("dataItemsLevel2").equalsIgnoreCase("Inbox")){
			        convertView = inflater.inflate(R.layout.itemg2t3, null);
			        textGroup = (TextView) convertView.findViewById(R.id.groupt3l2name);
			        TextView msgCount = (TextView) convertView.findViewById(R.id.msgCount);

			        msgCount.setText("999");
			        
		        }
		        
		        
			}else{
		        convertView = inflater.inflate(R.layout.itemg2t2, null);
		        textGroup = (TextView) convertView.findViewById(R.id.groupt2l2name);
			}
	        
	        textGroup.setText(mGroupsLevel2.get(groupPosition).get(childPosition).get("dataItemsLevel2"));
	        
			return convertView;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}
		
	}
	
}
