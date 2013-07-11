package tasklist;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestTask {

	@Test
	public void testCreateTask() {
		Task t1=null;
		
		//tarefa sem nome
		try{
			t1= new Task(null);
		}catch(Exception e){}
		Assert.assertTrue(t1==null);

		//data anterior
		try{
		t1= new Task("reuniao do projeto","",2000,10,5);
		}catch(Exception e){}
		Assert.assertTrue(t1==null);
		
	}

}
