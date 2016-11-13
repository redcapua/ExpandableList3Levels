package org.peredovik.expandablelist3levels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

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


    public Level1And2Adapter (){

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
