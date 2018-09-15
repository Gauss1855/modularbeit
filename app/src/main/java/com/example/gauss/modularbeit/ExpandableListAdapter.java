package com.example.gauss.modularbeit;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private List<String> meshGroup;
    private List<String> meshItem;

    public ExpandableListAdapter(Context ctx, List<String> meshGroup, List<String> meshItem) {
        this.ctx = ctx;
        this.meshGroup = meshGroup;
        this.meshItem = meshItem;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.content_productionview_group, null);
        }

        TextView productionViewGroup = (TextView) convertView
                .findViewById(R.id.productionViewGroup);
        productionViewGroup.setTypeface(null, Typeface.BOLD);
        productionViewGroup.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.content_productionview_item, null);
        }

        TextView productionViewItem = (TextView) convertView
                .findViewById(R.id.productionViewItem);

        productionViewItem.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
