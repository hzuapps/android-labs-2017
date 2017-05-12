package edu.hzuapps.androidlabs.homework.net1414080903230;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Net1414080903230_DiaryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Net1414080903230_DiaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Net1414080903230_DiaryFragment extends Fragment {
    private ListView list_show;


    private View specItemView;

    public Net1414080903230_DiaryFragment() {
    }
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net1414080903230__diary, container, false);
        view.findViewById(R.id.btn_writediary).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Net1414080903230_WriteDiaryActivity.class);
                startActivity(intent);
            }
        });


        File sdpath = Environment.getExternalStorageDirectory();

        //打开指定目录，显示项目说明书列表，供用户选择
        File dir = new File(sdpath,"diarydata");
        if(!dir.exists()){
            Log.d("test1","tet");
            dir.mkdirs();
        }
        //取出文件列表：
        final File[] files = dir.listFiles();
        try {

            List<HashMap<String, Object>> specs = new ArrayList<HashMap<String, Object>>();
            int seq = 0;
            for (File spec : files) {
                seq++;
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("seq", seq);
                hashMap.put("name", spec.getName());
                Log.d("test",spec.getName());
                specs.add(hashMap);
            }


            list_show = (ListView) view.findViewById(R.id.diary_list);

            SimpleAdapter spa = new SimpleAdapter(getActivity(), specs, R.layout.spec_item_list_1414080903230,
                    new String[]{"seq", "name"}, new int[]{R.id.seq, R.id.name});
            list_show.setAdapter(spa);
        }catch(NullPointerException e){


        }

        return view;
    }
}
