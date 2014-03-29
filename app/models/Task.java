package models;

import java.util.ArrayList;

import java.util.List;
import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;
/**
 * Created by Timo on 3/15/14.
 */
@Entity
public class Task extends Model{
    @Id
    public Long id;

    @Required
    public String label;


    public Task(String label){
        this.label = label;
    }

    public static Finder<Long,Task> find = new Finder(
            Long.class, Task.class
    );

    public static List<Task> all() {
        return find.all();
    }

    public static void create(Task task) {
        task.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();

    }


}
