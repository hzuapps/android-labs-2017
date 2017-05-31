package edu.hzuapps.androidlabs.homworks.net1414080903137;
import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.List;

        import edu.hzuapps.androidlabs.R;



  public class GoodsAdapter extends ArrayAdapter<Goods_info> {
    private int resourceId;

    public GoodsAdapter(Context context, int textViewResourceId, List<Goods_info> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Goods_info good = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView good_name = (TextView) view.findViewById(R.id.good_name);
        TextView good_number = (TextView) view.findViewById(R.id.good_number);
        good_name.setText(good.getGoodsname());
        good_number.setText(good.getGoodsnumber());
        return view;
    }
    public void refresh(){
        notifyDataSetChanged();
    }
}
