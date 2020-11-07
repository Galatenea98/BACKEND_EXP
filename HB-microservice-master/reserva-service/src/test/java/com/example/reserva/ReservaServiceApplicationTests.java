package com.example.reserva;


import com.example.reserva.entities.Reserva;
import com.example.reserva.services.impl.ReservaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class ReservaServiceApplicationTests {
	Reserva reserva = new Reserva();
	ReservaServiceImpl RSI = new ReservaServiceImpl();

	@Test
	void TestNuevaReserva() {
		Assertions.assertSame(RSI.save((reserva)),reserva);
	}

	@Test
	void TestFindAll()
	{

		List<Reserva>Actual = RSI.findAll();
		Assertions.assertEquals(0,Actual.size());
	}

	@Test
	void TestFindbyID()
	{
		Optional<Reserva> Expected = RSI.findById((long) 1);
		Assertions.assertSame(Expected.get(),reserva);
	}


}
