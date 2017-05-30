package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AssignFragment extends Fragment {
    public static List<Assignment> assignmentlist;
    private Button assin;
    private View view=null;
    private OnFragmentInteractionListener mListener;

    private AssignmentDao assignmentdao;
    private AssignmentAdapter assignmentadapter;

    private ListView assignLV;

    public AssignFragment() {
    }

    public static AssignFragment newInstance(String context) {
        AssignFragment fragment = new AssignFragment();
        Bundle args = new Bundle();
        args.putString("context", context);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1414080903212_assign,container,false);
        assignmentdao = new AssignmentDao(view.getContext());
        assignLV = (ListView) view.findViewById(R.id.assignList);
        assignmentlist = assignmentdao.findAll();
        assignmentadapter = new AssignmentAdapter();
        assignLV.setAdapter(assignmentadapter);
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume()  {
        assignmentlist = assignmentdao.findAll();
        assignmentadapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assin = (Button)view.findViewById(R.id.assignhw);
        assin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AssignActivity.class);
                startActivity(intent);
            }
        });
    }

    class AssignmentAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return assignmentlist.size();
        }

        @Override
        public Object getItem(int position) {
            return assignmentlist.get(position);
        }

        @Override
        public long getItemId(int position) {   return position;    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView != null?convertView:View.inflate(getActivity(), R.layout.assignlist_1414080903212, null);
            TextView idTV = (TextView) item.findViewById(R.id.assign_id);
            TextView titleTV = (TextView) item.findViewById(R.id.assign_title);
            TextView contentTV = (TextView) item.findViewById(R.id.assign_content);
            TextView timeTV = (TextView) item.findViewById(R.id.sub_date);

            final Assignment ass = assignmentlist.get(position);
            idTV.setText(ass.getId()+"");
            titleTV.setText(ass.getHomework_title());
            contentTV.setText(ass.getHomework_content());
            timeTV.setText(ass.getSubmit_time());
            return item;
        }
    }
}