package controllers;

import models.Task;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("lol");
    }

    public static Result displayList(){

        Task task=new Task();

        task.add("Timothy");

        return ok(String.valueOf(task.getListItems()));

    }

}
