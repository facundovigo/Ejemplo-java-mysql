package TestCliente;


import org.junit.Test;

import junit.framework.TestCase;
import model.Cliente;


public class TestNombreCliente extends TestCase{

	private Cliente cliente = new Cliente();
	
	@Test
	public void testparaSaberElNombre() {;
		String esperado = "prueba";
		this.cliente.setNombre("prueba");
		String actual = cliente.getNombre();
	
		assertTrue(cliente.getNombre()=="prueba");
		assertEquals(esperado,actual);
	}
}
