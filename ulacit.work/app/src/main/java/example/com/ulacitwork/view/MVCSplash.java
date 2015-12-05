package example.com.ulacitwork.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import example.com.ulacitwork.R;

/**
 * Created by Administrator on 12/4/2015.
 */
public class MVCSplash extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_splash);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MVCSplash.this, MVCView.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}

