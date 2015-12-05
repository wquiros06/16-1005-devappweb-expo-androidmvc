package example.com.ulacitwork.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import example.com.ulacitwork.model.MVCModel;
import example.com.ulacitwork.service.StudentService;


/**
 * Created by Administrator on 12/4/2015.
 */
//https://api.mongolab.com/api/1/databases/avantica-test/collections/students?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb

public class MVCController {
    private MVCModel model;
    private List<String> tasks;
    Context context;

    public MVCController(Context app_context) {
        context = app_context;
        tasks = new ArrayList<String>();
        model = new MVCModel();
    }


    public List<String> getTasks() {

        StudentService studentService = new StudentService(context);

        try {
            LoadTasks(studentService.execute().get());
        } catch (ExecutionException ee) {
            ee.printStackTrace();
            Log.d("==>>Error: ", ee.toString());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            Log.d("==>>Error: ", ie.toString());
        }

        return tasks;
    }

    private void LoadTasks(ArrayList<MVCModel> students) {
        for (MVCModel student : students) {
            this.tasks.add(student.getName() + "-" + student.getCourse());
        }
    }
}
