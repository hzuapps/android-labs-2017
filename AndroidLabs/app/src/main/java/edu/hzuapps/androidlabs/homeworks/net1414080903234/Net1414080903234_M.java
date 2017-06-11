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
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Net1414080903234_M.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Net1414080903234_M#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Net1414080903234_M extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    private TextView incomeTV;
    private TextView outlayTV;
    private TextView moneyTV;
    private Button alalyBn;
    private OnFragmentInteractionListener mListener;
    private View view = null;
    public static double money = 0;
    public static double income = 0;
    public static double outlay = 0;

    private int insize = 0;
    private int outsize = 0;

    public Net1414080903234_M() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Net1414080903234_M.
     */
    // TODO: Rename and change types and number of parameters
    public static Net1414080903234_M newInstance(String message) {
        Net1414080903234_M fragment = new Net1414080903234_M();
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

        view = inflater.inflate(R.layout.fragment_net1414080903234__m,container,false);

        initValue();
        setValue();



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
    private void initValue(){
        money = 0;
        income = 0;
        outlay = 0;
        incomeTV = (TextView)view.findViewById(R.id.tiview);
        outlayTV = (TextView)view.findViewById(R.id.toview);
        moneyTV = (TextView)view.findViewById(R.id.tmview);
        Net1414080903234_I.inlist = new Incomedao(view.getContext()).findALL();
        Net1414080903234_O.outlist = new Outlaydao(view.getContext()).findALL();
        insize =  Net1414080903234_I.inlist.size();
        outsize = Net1414080903234_O.outlist.size();
        for(int i = 0;i <insize;i++){
            income = income + Net1414080903234_I.inlist.get(i).getMoney();
        }
        for(int i = 0;i < outsize;i++){
            outlay = outlay + Net1414080903234_O.outlist.get(i).getMoney();
        }
        money = income - outlay;
    }

    private void setValue(){
        incomeTV.setText(String.valueOf(income));
        outlayTV.setText(String.valueOf(outlay));
        moneyTV.setText(String.valueOf(money));
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        setValue();
        super.onResume();
    }

     @Override
   public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

         alalyBn = (Button)getActivity().findViewById(R.id.analyjson);
         alalyBn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Net1414080903234AnalyActivity.class);
                startActivity(intent);
            }
});
        }

}
