package pe.edu.upc.cliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.upc.cliente.entities.Cliente;
import pe.edu.upc.cliente.services.impls.ClienteServiceImpl;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ClienteServiceApplicationTests {
	Cliente cliente = new Cliente();
	ClienteServiceImpl CSI = new ClienteServiceImpl();

	@Test
	void TestAgregarCliente() {
		Cliente Expected = CSI.save(cliente);
		Assertions.assertSame(Expected, cliente);
	}

	@Test
	void TestFindByDocumento(){
		Optional<Cliente> Expected = CSI.findByNumeroDocumento("12345678");
		Assertions.assertSame(Expected.get(),cliente);
	}
	@Test
	void TestFindAll()
	{
		List<Cliente> Expected = CSI.findAll();
		Assertions.assertEquals(Expected.size(),0);
	}
}
