package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Net1414080903212FirstFragment extends Fragment {
    private String context;
    private TextView mTextView;

    public Net1414080903212FirstFragment(String context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment1414080903212,container,false);
        mTextView = (TextView)view.findViewById(R.id.txt_content);
        mTextView.setText(context);
        return view;
    }
}
