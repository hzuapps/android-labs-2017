package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
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
 * {@link Net1414080903234_I.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Net1414080903234_I#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Net1414080903234_I extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static List<Income> inlist;
    // TODO: Rename and change types of parameters
    private String flag;
    private TextView mTextview;
    private Button add;
    private View view = null;
    private OnFragmentInteractionListener mListener;

    //ListView中的TextView
    private TextView id;
    private TextView drawee;
    private TextView money;
    private TextView date;
    //数据库操作
    private Incomedao incomedao;
    //适配器
    private IncomeAdapter incomeadapter;
    //ListView
    private ListView incomeLV;
    public Net1414080903234_I() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Net1414080903234_I.
     */
    // TODO: Rename and change types and number of parameters
    public static Net1414080903234_I newInstance(String message) {
        Net1414080903234_I fragment = new Net1414080903234_I();
        Bundle args = new Bundle();
        args.putString("message", message);
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_net1414080903234__i,container,false);
        incomedao = new Incomedao(view.getContext());
        incomeLV = (ListView) view.findViewById(R.id.incomeList);
        inlist = incomedao.findALL();
        incomeadapter = new IncomeAdapter();
        incomeLV.setAdapter(incomeadapter);
        return view;
    }
// TODO: Rename method, update argument and hook method into UI event
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            incomeadapter.notifyDataSetChanged();
            //相当于Fragment的onResume
        } else {
            //相当于Fragment的onPause
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        add = (Button)view.findViewById(R.id.addi);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Net1414080903234AddIncomeActivity.class);
                startActivity(intent);
            }
        });
    }


    class IncomeAdapter extends BaseAdapter {
        public int getCount(){
            return inlist.size();
        }

        @Override
        public Object getItem(int position) {
            return inlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView != null?convertView:View.inflate(getContext(),R.layout.inlist_net1414080903234,null);
            TextView idTV = (TextView) item.findViewById(R.id.incomeid);
            TextView dateTV = (TextView) item.findViewById(R.id.idatet);
            TextView draweeTV = (TextView) item.findViewById(R.id.idraweet);
            TextView moneyTV = (TextView) item.findViewById(R.id.imoneyt);

            final Income in = inlist.get(position);
            idTV.setText(in.getId()+"");
            dateTV.setText(in.getDate()+"  ");
            draweeTV.setText(in.getPayer());
            moneyTV.setText(String.valueOf(in.getMoney()));
            return item;
        }
    }
}
