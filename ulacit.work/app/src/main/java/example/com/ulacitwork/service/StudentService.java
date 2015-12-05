package example.com.ulacitwork.service;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 12/4/2015.
 */
public class StudentService extends AsyncTask<Void, Void, ArrayList<String>> {

    Context context;

    public StudentService(Context context) {
        this.context = context;
    }

    private final String sURL = "https://api.mongolab.com/api/1/databases/avantica-test/collections/students?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";


    protected ArrayList<String> doInBackground(Void... params) {
        ArrayList<String> students = new ArrayList<String>();
        try {
            HttpClient cliente = new DefaultHttpClient();
            HttpGet request = new HttpGet(sURL);
            HttpResponse response = cliente.execute(request);

            try {
                String respStr = EntityUtils.toString(response.getEntity());

                JSONArray respJSON = new JSONArray(respStr);



                for (int i = 0; i < respJSON.length(); i++) {
                    JSONObject obj = respJSON.getJSONObject(i);

                    String name = obj.getString("name");
                    String course = obj.getString("course");
                    String student = name + " - " + course;
                    students.add(student);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return students;

    }

}
