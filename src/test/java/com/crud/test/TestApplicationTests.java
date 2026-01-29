package com.crud.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.crud.test.domain.Client;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
     void crearCliente_ok() {
    Client cliente = new Client();
     cliente.setNombre("Jose Lema");

}

}
