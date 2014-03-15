package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timo on 3/15/14.
 */
public class Task {
    public Long id;
    public String label;
    public static ArrayList<String> names;

    public Task(){
        names = new ArrayList<String>();
    }
    public void add(String name){
     names.add(name);
    }
    public ArrayList<String> getList(){
        return names;
    }
}
