package com.example.membresia;

import com.example.membresia.entities.Membresia;
import com.example.membresia.entities.PagoMembresia;
import com.example.membresia.entities.Tarjeta;
import com.example.membresia.services.impl.MembresiaServiceImpl;
import com.example.membresia.services.impl.PagoMembresiaServiceImpl;
import com.example.membresia.services.impl.TarjetaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertFalse;
import java.util.List;

@SpringBootTest
class MembresiaServiceApplicationTests {
	Membresia membresia = new Membresia();
	MembresiaServiceImpl MSI = new MembresiaServiceImpl();
	PagoMembresia pagomembresia = new PagoMembresia();
	PagoMembresiaServiceImpl PMSI = new PagoMembresiaServiceImpl();
	Tarjeta tarjeta = new Tarjeta();
	TarjetaServiceImpl TSI  = new TarjetaServiceImpl();

	@Test
	void TestComprarMembresia() {
		Membresia Expected = MSI.save(membresia);
		Assertions.assertSame(Expected,membresia);
	}
	@Test
	void TestIngresarPagoMembresia()
	{
		PagoMembresia Expected = PMSI.save(pagomembresia);
		Assertions.assertSame(Expected,pagomembresia);
	}
	@Test
	void TestAgregarTarjeta(){
		Tarjeta Expected = TSI.save(tarjeta);
		Assertions.assertSame(Expected, tarjeta);
	}
	@Test
	void TestEliminarTarjeta()
	{
		try {
			TSI.deleteById((long) 1);
		} finally {
			Assert.isTrue(true,"Eliminacion Correcta");
		}
		;
		Assert.state(false, "Eliminacion Fallida");
	}
	@Test
	void TestListarTarjetas()
	{
		List<Tarjeta> Expected = TSI.findAll();
		Assertions.assertSame(Expected, TSI.findAll());
	}
}
