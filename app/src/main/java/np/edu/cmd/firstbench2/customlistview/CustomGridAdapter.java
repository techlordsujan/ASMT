package np.edu.cmd.firstbench2.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TECHLORD on 1/19/2017.
 */
public class CustomGridAdapter extends BaseAdapter {

    String[] title,desc;
    int[] image;
    LayoutInflater inflater;

    CustomGridAdapter(Context c,String[] t,String[] d,int[] i){
        title =t;
        desc =d;
        image=i;
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
        View grid = inflater.inflate(R.layout.my_grid,null);
        TextView tView = (TextView) grid.findViewById(R.id.gridtitle);
        TextView dView = (TextView) grid.findViewById(R.id.griddesc);
        ImageView iView = (ImageView) grid.findViewById(R.id.gridimage);

        tView.setText(title[position]);
        dView.setText(desc[position]);
        iView.setImageResource(image[position]);

        return grid;
    }
}
