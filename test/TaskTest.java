import models.Task;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Timo on 3/15/14.
 */
public class TaskTest {

    @Test
    public void shouldGetList(){
        Task task = new Task();

        ArrayList names = task.getList();

        assertEquals(names, Task.names);


    }

    @Test
    public void shouldAddToList(){
        Task task = new Task();
        int listSizeBefore = Task.names.size();
        task.add("Aidah");
        int listSizeAfter = Task.names.size();
        assertThat(listSizeAfter-listSizeBefore, is(1));


    }


}
