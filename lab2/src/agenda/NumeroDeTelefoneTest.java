package agenda;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class NumeroDeTelefoneTest {	

	@Test
	public void testFormato() {
		NumeroDeTelefone num1 = new NumeroDeTelefone("74","10101010",Operadora.TIM);
		Assert.assertTrue(num1.getNumero().length()==8);
		Assert.assertTrue(num1.getCodigoDeArea().length()==2 || num1.getCodigoDeArea().length()==0);
		
	}

}
