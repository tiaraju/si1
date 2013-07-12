package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tasklist.Data;

public class TestData {

	
	Data data1;
	Data data2;
	@Before
	public void init() throws Exception{
		data1 = new Data(10,10,2010);
		data2 = new Data(12,5,2025);
		
	}
	
	@Test
	public void TestaDia(){
		Assert.assertTrue(data1.getDia()>0);
		Assert.assertTrue((data2.getDia()>0));
	
	}
	@Test
	public void TestaMes(){
		Assert.assertTrue(data1.getMes()>0 && data1.getMes()<13);
		Assert.assertTrue((data2.getMes()>0));
	
	}
	
	@Test
	public void TestaAno(){
		Assert.assertTrue(data1.getAno()>0);
		Assert.assertTrue((data2.getAno()>0));
	
	}


}
