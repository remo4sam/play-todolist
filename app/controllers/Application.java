package controllers;

import models.Task;
import play.*;
import play.mvc.*;
import play.data.Form;

import views.html.*;

public class Application extends Controller {

    static Form<Task> taskForm = Form.form(Task.class);

    public static Result index() {
        return ok("Your new application is ready.");
    }

    public static Result tasks() {
        return ok(views.html.listOfNames.render(Task.all(), taskForm));

    }

    public static Result newTask() {
        Form<Task> filledForm = taskForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.listOfNames.render(Task.all(), filledForm)
            );
        } else {
            Task.create(filledForm.get());
            return redirect(controllers.routes.Application.tasks());
        }
    }

    public static  Result deleteTask(Long id){
        Task.delete(id);
        return redirect(controllers.routes.Application.tasks());

    }



}
