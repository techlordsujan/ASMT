package np.edu.cmd.firstbench2.customlistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {
    GridView gview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gview = (GridView) findViewById(R.id.gridView);

        String[] TITLE = new String[]{"Title A","TItle B","Title C",
                "Title D","TItle E","Title F",
                "Title G","TItle H","Title I"};
        String[] DESC = new String[]{"Desc A","Desc B","Desc C",
                "Desc D","Desc E","Desc F",
                "Desc G","Desc H","Desc I"};
        int[] IMAGE = new int[]{R.drawable.grid_image,R.drawable.thumb_male,R.drawable.thumb_female,
                R.drawable.thumb_female,R.drawable.grid_image,R.drawable.thumb_male,
                R.drawable.thumb_male,R.drawable.grid_image,R.drawable.thumb_female};

        CustomGridAdapter cAdapter = new CustomGridAdapter(this,TITLE,DESC,IMAGE);

        gview.setAdapter(cAdapter);

    }

}
