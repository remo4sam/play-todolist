package models;

import java.util.ArrayList;

/**
 * Created by levelup on 3/22/14.
 */
public class TaskManager {
    public static ArrayList<Task> taskList;

   public TaskManager(){
        taskList=new  ArrayList<Task>();


    }

    public static void add(Task task){

        taskList.add(task);

    }

    public static ArrayList<Task> getList(){

     return taskList;
    }
}
