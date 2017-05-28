package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.app.FragmentManager;
import android.content.DialogInterface;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Net1414080903234_O.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Net1414080903234_O#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Net1414080903234_O extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static List<Outlay> outlist;
    // TODO: Rename and change types of parameters
    private String flag;
    private Button add;
    private View view = null;
    //ListView中的TextView
    // private TextView id;
    // private TextView usage;
    // private TextView money;
    // private TextView date;
    //数据库操作
    private Outlaydao outlaydao;
    //适配器
    private Net1414080903234_O.OutlayAdapter outlayadapter;
    //ListView
    private ListView outlayLV;
    public Net1414080903234_O() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Net1414080903234_O.
     */
    // TODO: Rename and change types and number of parameters
    public static Net1414080903234_O newInstance(String message) {
        Net1414080903234_O fragment = new Net1414080903234_O();
        Bundle args = new Bundle();
        args.putString("message", message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            outlayadapter.notifyDataSetChanged();
            //相当于Fragment的onResume
        } else {
            //相当于Fragment的onPause
        }
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_net1414080903234__o,container,false);
        outlaydao = new Outlaydao(view.getContext());
        outlayLV = (ListView) view.findViewById(R.id.outlayList);
        outlist = outlaydao.findALL();
        outlayadapter = new Net1414080903234_O.OutlayAdapter();
        outlayLV.setAdapter(outlayadapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction out this fragment to be communicated
     * to the activity and potentially other fragments contained out that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        add = (Button)view.findViewById(R.id.addo);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Net1414080903234AddOutlayActivity.class);
                startActivity(intent);
            }
        });
    }

    class OutlayAdapter extends BaseAdapter {
        public int getCount() {
            return outlist.size();
        }

        @Override
        public Object getItem(int position) {
            return outlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView != null ? convertView : View.inflate(getContext(), R.layout.outlist_net1414080903234, null);
            TextView idTV = (TextView) item.findViewById(R.id.outlayid);
            TextView dateTV = (TextView) item.findViewById(R.id.odatet);
            TextView usageTV = (TextView) item.findViewById(R.id.ousaget);
            TextView moneyTV = (TextView) item.findViewById(R.id.omoneyt);

            final Outlay out = outlist.get(position);
            idTV.setText(out.getId() + "");
            dateTV.setText(out.getDate() + "  ");
            usageTV.setText(out.getUsage());
            moneyTV.setText(String.valueOf(out.getMoney()));
            return item;
        }
    }  
}


