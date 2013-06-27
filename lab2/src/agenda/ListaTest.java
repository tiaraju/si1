package agenda;

import java.util.ArrayList;

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
		lista.addContato("Joao",new ArrayList<NumeroDeTelefone>(),new ArrayList<String>());
		Assert.assertFalse(lista.getTotalDeContatos() == 0);
	}
	
	@Test
	public void testListarcontatos(){
		Assert.assertNotNull(lista.getContatos());
	}

}
