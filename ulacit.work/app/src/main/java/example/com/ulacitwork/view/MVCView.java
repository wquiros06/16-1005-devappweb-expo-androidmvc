package example.com.ulacitwork.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import example.com.ulacitwork.R;
import example.com.ulacitwork.controller.MVCController;


public class MVCView extends Activity {
    public static final String APP_TAG = "example.com.ulacit";
    public ListView lvTask;
    private Button btNewTask;
    private MVCController controller;
    ProgressDialog prgDialog;

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.ui_main);
        this.controller = new MVCController(this);
        this.lvTask = (ListView) this.findViewById(R.id.lvTask);
        this.btNewTask = (Button) this.findViewById(R.id.btRefreshTask);
        this.btNewTask.setOnClickListener(this.handleNewTaskEvent);


        prgDialog = new ProgressDialog(this);
        // Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);

        this.populateTasks();
    }

    private void populateTasks() {
        final List<String> tasks = this.controller.getTasks();
        Log.d(MVCView.APP_TAG, String.format("%d found tasks ", tasks.size()));
        this.lvTask.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasks.toArray(new String[]{})));
        prgDialog.hide();
    }



    private final View.OnClickListener handleNewTaskEvent = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            prgDialog.show();
            Log.d(APP_TAG, "New Task button added");
            MVCView.this.populateTasks();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

