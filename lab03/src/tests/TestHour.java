package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tasklist.Hour;

public class TestHour {

	Hour hour;
	
	@Before
	public void init() {
		try{
		hour = new Hour(12, 12);
		}catch(Exception e){
			
		}
	}
	
	
	@Test
	public void TestFormat(){
		Assert.assertTrue(hour!=null);
		Assert.assertEquals(12, hour.getHora());
		Assert.assertEquals(12, hour.getMinutos());
		try{
		hour.setHora(15);
		hour.setMinutos(35);
		}catch(Exception e){}
		Assert.assertEquals(15, hour.getHora());
		Assert.assertEquals(35, hour.getMinutos());
		
	}
	@Test
	public void TestCriation(){
		try{
			hour = new Hour(-1,-1);
			Assert.fail();
		}catch(Exception e){
		}
	}
}
