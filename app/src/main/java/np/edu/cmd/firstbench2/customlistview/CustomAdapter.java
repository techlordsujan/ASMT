package np.edu.cmd.firstbench2.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TECHLORD on 1/18/2017.
 */
public class CustomAdapter extends BaseAdapter {

    String[] title,desc;
    int[] image;
    LayoutInflater inflater;

    CustomAdapter(Context c,String[] t,String[] d,int[] i){
        title = t;
        desc = d;
        image = i;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.custom_list,null);

        TextView tV = (TextView) row.findViewById(R.id.listTitle);
        TextView dV = (TextView)row.findViewById(R.id.listDesc);
        ImageView iV = (ImageView)row.findViewById(R.id.listImage);

        tV.setText(title[position]);
        dV.setText(desc[position]);
        iV.setImageResource(image[position]);

        return row;
    }
}
