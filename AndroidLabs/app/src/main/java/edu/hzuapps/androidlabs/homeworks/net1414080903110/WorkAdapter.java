package edu.hzuapps.androidlabs.homeworks.net1414080903110;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.R;

/**
 * 设置WorkAdapter适配器，通过这个适配器设置ListView的样式
 */

public class WorkAdapter extends ArrayAdapter<Work_Info> {
    private int resourceId;

    public WorkAdapter(Context context, int textViewResourceId, List<Work_Info> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Work_Info work = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView workname = (TextView) view.findViewById(R.id.work_name);
        workname.setText(work.getWorkname());
        return view;
    }
}
