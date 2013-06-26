package agenda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListaTest {
	
	ListaDeContatos lista;

	@Before
	public void init(){
		lista = new ListaDeContatos();
	}
	
	
	@Test
	public void testCadastraNovoContato() {
		
		Assert.assertEquals(lista.getTotalDeContatos(), 0);
		lista.addContato("Joao",new ArrayList<String>(),new ArrayList<String>());
		Assert.assertFalse(lista.getTotalDeContatos() == 0);
	}
	
	@Test
	public void testListarcontatos(){
		Assert.assertNotNull(lista.getContatos());
	}

}
