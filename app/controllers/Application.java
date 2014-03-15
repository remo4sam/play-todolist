package controllers;

import models.Task;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result displayList() {
        Task task = new Task();
        task.add("Aidah");
        task.add("Ritah");
        task.add("timothy");
        task.add("Gladys");
        return ok(String.valueOf(task.getList()));
    }

}
