package models;

import java.util.ArrayList;
/**
 * Created by levelup on 3/15/14.
 */
public class Task {
    public static ArrayList<String> list;

    public  Task(){
        list = new ArrayList<String>();
    }

    public ArrayList<String> add(String listItem) {

        list.add(listItem);

        return list;
    }

    public String getListItems() {
String listItems="";
for(int i=0;i<list.size();i++){

    listItems+=list.get(i).toString()+"\n";

}
        return listItems;
    }

    public ArrayList<String> getList() {

        return list;
    }
}
