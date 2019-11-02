package com.nbu.demo;

import com.nbu.demo.model.User;
import com.nbu.demo.repo.UserRepo;
import com.nbu.demo.service.AddressService;
import com.nbu.demo.service.GoodService;
import com.nbu.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {DemoApplication.class})
public class DemoApplicationTests {

	@Autowired
	AddressService addressService;

	@Autowired
	GoodService goodService;

	@Autowired
	UserService userService;
	//@Autowired
	//UserRepo userService;

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	@Commit
	public void testAddUserCrudRepository(){
		User anton = new User();
		anton.setFirstName("Anton");
		anton.setLastName("Anton'ch");
		anton.setLocale("ua");
		anton.setEmail("user@mail2.ua");
		userService.save(anton);
	}

	@Test
	@Transactional
	public void testUserCrudRepository(){
		Optional <User> employeesOptional = userService.findById(Long.valueOf(1));
		System.out.println(employeesOptional
		.map(e->e.getFirstName() + " " + e.getLastName())
		.orElse("not found"));
	}

}
