import models.Task;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

import static org.junit.Assert.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class TaskTest {

    @Test
    public void shouldTestLabelOfTask(){

        Task task =new Task("go to school");

        assertThat(task.label,is("go to school"));
    }

    public Task taskFactory(String taskName){
        Task task = new Task(taskName);
        task.save();
        return task;
    }

    @Test
    public void shouldTestSaveTask(){

        running(fakeApplication(), new Runnable() {
            public void run() {
                Task task1 = taskFactory("eat lunch");
                Task task2 = taskFactory("do homework");
                List<Task> result = Task.find.all();
                assertThat(result.size(), is(2));
                assertThat(result.get(0).label, is(task1.label));
                assertThat(result.get(1).label, is(task2.label));
            }
        });


    }

    @Test
    public void shouldTestDeletionOfATask(){

       running(fakeApplication(), new Runnable() {
                public void run() {
                    Task task1 = taskFactory("delete Task");
                    Task task2 = taskFactory("delete second Task");

                    List<Task> result1= Task.find.all();
                    assertThat(result1.size(), is(2));
                    Long taskid1 = result1.get(0).id;
                    Task.delete(taskid1);
                    List<Task> result2= Task.find.all();
                    assertThat(result2.size(), is(1));
                    assertNull(Task.find.byId(taskid1));
                }
            });
    }

}
