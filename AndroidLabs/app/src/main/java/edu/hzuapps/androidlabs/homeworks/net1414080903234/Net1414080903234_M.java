package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private String mContext;
    private TextView mTextview;
    private OnFragmentInteractionListener mListener;

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

        mContext = getArguments().getString("message");
        View view = inflater.inflate(R.layout.fragment_net1414080903234__m,container,false);
        mTextview = (TextView)view.findViewById(R.id.tview);
        mTextview.setText(mContext);
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
}
