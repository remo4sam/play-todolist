import models.Task;
import models.TaskManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by levelup on 3/22/14.
 */
public class TaskManagerTest {

    @Test
    public void shouldGetList(){
        TaskManager taskManager = new TaskManager();

        ArrayList<Task> names=taskManager.getList();


        assertEquals(names, TaskManager.taskList);


    }


    @Test
    public void shouldAddToList(){
        Task task = new Task("get started");
        TaskManager taskManager = new TaskManager();

        int listSizeBefore = TaskManager.taskList.size();

        taskManager.add(task);
        int listSizeAfter = TaskManager.taskList.size();
        assertThat(listSizeAfter-listSizeBefore, is(1));
    }
}
