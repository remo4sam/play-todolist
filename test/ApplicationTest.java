import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.Application;
import models.Task;
import org.junit.*;

import play.data.Form;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {
    Form<Task> taskForm = Form.form(Task.class);
    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }

    @Test
    public void shouldTestRenderTasks(){
        running(fakeApplication(), new Runnable() {
            public void run() {
            new Task("play music").save();
            new Task("close laptop").save();
            List<Task> tasks= Task.find.all();
            Content html=views.html.listOfNames.render(tasks, taskForm);

            assertThat(contentType(html)).isEqualTo("text/html");
            assertThat(contentAsString(html)).contains("play music");
            assertThat(contentAsString(html)).contains("close laptop");
                }});
        }
}
