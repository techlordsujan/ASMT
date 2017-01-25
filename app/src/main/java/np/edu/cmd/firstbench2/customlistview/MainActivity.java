package np.edu.cmd.firstbench2.customlistview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] title = new String[] {"GridView","Custom Toast",
                "Alert Dialog","DialogList","Custom Dialog"};
        String[] desc = new String[] {"Desc a", "Desc b","Desc c","Desc d","Desc e"};
        int[] image = new int[] {R.mipmap.ic_launcher,R.drawable.grid_image,
                R.mipmap.ic_launcher,R.drawable.grid_image,R.mipmap.ic_launcher};



        list = (ListView) findViewById(R.id.listView);

        CustomAdapter myadapter = new CustomAdapter(this,title,desc,image);

        list.setAdapter(myadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i = new Intent(getApplicationContext(),GridViewActivity.class);
                    startActivity(i);
                }else if(position==1){
                    showCustomToast("My Toast Message");
                }else if(position==2){
                    showAlertDialog("MY first Dialog");
                }else if(position==3){
                    showDialogList();
                }else if(position==4){
                    showCustomDialog("this is my first custom dialog messsage");
                }
            }
        });

    }
    public void showCustomToast(String msg){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,null);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);
        Toast custom = new Toast(this);
        custom.setGravity(Gravity.CENTER_VERTICAL, 0, 400);
        custom.setView(layout);
        custom.show();

    }
    public void showAlertDialog(String msg){
        AlertDialog.Builder alert_dialog = new AlertDialog.Builder(this);
        alert_dialog.setTitle("Prompt");
        alert_dialog.setIcon(R.drawable.grid_image);
        alert_dialog.setMessage(msg);
        alert_dialog.setCancelable(false);
        alert_dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCustomToast("OK button was clickked");
                dialog.cancel();
            }
        });
        alert_dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCustomToast("Cancel button was clicked");
                dialog.cancel();
            }
        });
        alert_dialog.show();
    }

    public void showDialogList(){
        AlertDialog.Builder list_dialog = new AlertDialog.Builder(this);
        list_dialog.setTitle("List");
        final String[] listitem = new String[]{"Item1","Item2","Item3","Item4"};
        list_dialog.setItems(listitem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCustomToast(listitem[which]);
                dialog.cancel();
            }
        });
        list_dialog.show();
    }
    public void showCustomDialog(String msg){
        final Dialog customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.custom_dialog);
        customDialog.setTitle("CustomPrompt");
        TextView tv = (TextView) customDialog.findViewById(R.id.dialog_text);
        tv.setText(msg);
        Button btn = (Button) customDialog.findViewById(R.id.dialog_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.cancel();
                showCustomToast("click me button was clicked");

            }
        });
        customDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
