package aryaan_part_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TaskTest {
    private final Task task;

    public TaskTest() {
        task = new Task();
    }

    @Test
    public void testCheckTaskDescription_Success() {
        assertTrue(task.checkTaskDescription("Valid description")); // Less than 50 characters
    }

    @Test
    public void testCheckTaskDescription_Failure() {
        assertFalse(task.checkTaskDescription("This description is longer than 50 characters and hence invalid.")); // More than 50 characters
    }

    @Test
    public void testCreateTaskID() {
        task.setNumberOfTasks(1);
        task.getStrTaskName()[0] = "login feature";
        task.getStrDevelopFirstName()[0] = "Robbyn";
        task.getStrDeveloperLastName()[0] = "Harrison";
        assertEquals("L:0:RSN", task.createTaskID(0)); // Expected TaskID
    }

    @Test
    public void testCreateTaskID_SecondCase() {
        task.setNumberOfTasks(1);
        task.getStrTaskName()[0] = "add task feature";
        task.getStrDevelopFirstName()[0] = "Mike";
        task.getStrDeveloperLastName()[0] = "Smith";
        assertEquals("A:0:MSH", task.createTaskID(0)); // Expected TaskID
    }

    @Test
    public void testAccumulateTotalHours() {
        task.setNumberOfTasks(2);
        task.getIntTaskDuration()[0] = 8;
        task.getIntTaskDuration()[1] = 10;
        assertEquals(18, task.returnTotalHours(1)); // Expected total hours
    }
}
