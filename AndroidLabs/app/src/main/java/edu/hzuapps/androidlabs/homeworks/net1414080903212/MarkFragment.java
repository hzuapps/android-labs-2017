package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MarkFragment extends Fragment {
    public static List<Mark> marklist;
    private Button markbtn;
    private View view;
    private OnFragmentInteractionListener mListener;


    private MarkDao markdao;
    private MarkAdapter markadapter;

    private ListView markLV;

    public MarkFragment() {
    }

    public static MarkFragment newInstance(String context) {
        MarkFragment fragment = new MarkFragment();
        Bundle args = new Bundle();
        args.putString("context", context);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1414080903212_mark,container,false);
        markdao = new MarkDao(view.getContext());
        markLV = (ListView) view.findViewById(R.id.markList) ;
        marklist = markdao.findAll();
        markadapter = new MarkAdapter();
        markLV.setAdapter(markadapter);
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume()  {
        marklist = markdao.findAll();
        markadapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        markbtn = (Button)view.findViewById(R.id.markhw);
        markbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarkActivity.class);
                startActivity(intent);
            }
        });
    }

    class MarkAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return marklist.size();
        }

        @Override
        public Object getItem(int position) {
            return marklist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView != null?convertView:View.inflate(getActivity(), R.layout.marklist_1414080903212,null);
            TextView stu_idTV = (TextView) item.findViewById(R.id.mark_stuid);
            TextView gradeTV = (TextView) item.findViewById(R.id.mark_grade);
            TextView titleTV = (TextView) item.findViewById(R.id.mark_title);
            TextView commentTV = (TextView) item.findViewById(R.id.mark_comment);

            final Mark mar = marklist.get(position);
            stu_idTV.setText(mar.getStuid()+"");
            titleTV.setText(mar.getHomework_title());
            gradeTV.setText(mar.getGrade());
            commentTV.setText(mar.getComment());
            return item;
        }
    }
}