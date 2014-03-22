import models.Task;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by levelup on 3/15/14.
 */
public class TaskTest {

    @Test
    public void shouldTestForAdditionToList(){
        //Given
        Task task = new Task();
          int size=task.list.size();
          ArrayList<String> TestList= task.add("thoughtworks coursewak");

        assertThat(TestList.size()).isGreaterThan(size);

    }

    @Test
    public void shouldTestForGettingItemFromList(){

      Task task1 = new Task();

        ArrayList<String> items = task1.getList();

        assertEquals(Task.list,items);


    }

}
