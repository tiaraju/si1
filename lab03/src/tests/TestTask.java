package tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tasklist.Data;
import tasklist.Hour;
import tasklist.Task;

public class TestTask {

	Task task;
	Hour hour;
	Data data;


	@Before
	public void init() {
		try{
			this.task= new Task("meetting");
			this.hour = new Hour(12, 12);
			this.data = new Data(10,10,2013);
		}catch(Exception e){

		}
	}

	@Test
	public void TestData(){
		Assert.assertTrue(data.getAno()>0);
		Assert.assertTrue(data.getMes()>0);
		Assert.assertTrue(data.getDia()>0);
		try{
			Assert.assertTrue(data.equals(new Data(10,10,2013)));
			data.setAno(2013);
			data.setDia(10);
			data.setMes(5);
			Assert.assertTrue(data.equals(new Data(10,5,2013)));
		}catch(Exception e){
			
		}

	}
	
	@Test
	public void TestTasks(){
		
		Assert.assertTrue(task.getNome() != null);
		Assert.assertTrue(task.getNome().equals("meetting"));
		task.setNome("appointment");
		Assert.assertTrue(task.getNome().equals("appointment"));
		try{
			task = new Task(null);
			Assert.fail();
			task = new Task("");
			Assert.fail();
		}catch (Exception e){
		}
		Assert.assertTrue(task.getNome()!= null);
		Assert.assertTrue(!task.getNome().equals(""));
	}

	
}
