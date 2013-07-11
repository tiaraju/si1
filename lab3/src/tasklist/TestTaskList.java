package tasklist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTaskList {

	TaskList list;

	@Before
	public void init(){
		list = new TaskList();
	}

	@Test
	public void TestAddTask() {
		Assert.assertEquals(0, list.size());
		try{
			list.addTask("reuniao");
		}catch(Exception e){}
		Assert.assertNotEquals(0, list.size());
	}

	@Test
	public void testCompleteTask(){
		Task t1=null;
		try{
			t1 = new Task("reuniao");
			list.addTask(t1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(list.getCompletedTasks().size()==0);
		list.markAsCompleted(t1);
		Assert.assertTrue(list.getCompletedTasks().size()!=0);
		Assert.assertTrue(list.getPendingTasks().size()==0);
		Assert.assertTrue(t1.IsCompleted());
	}

}
