package ru.mustafin.springBootCrud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mustafin.springBootCrud.Service.UserService;

@SpringBootTest
class SpringBootCrudApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
	}

}
