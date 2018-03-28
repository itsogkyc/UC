package kr.co.uclick.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserAddTest {

	@Autowired
	private UserService userService;

	@BeforeTransaction
	public void addUser() {
		// *c : creat
		User user = new User();
		user.setName("kim");
		user.setPhone(new Phone("010-1111-2222"));
		userService.save(user);
		user = new User();
		user.setName("Lee1");
		user.setPhone("010-1111-2222");
		userService.save(user);
		user = new User();
		user.setName("Lee2");
		user.setPhone("010-1111-2222");
		userService.save(user);
		user = new User();
		user.setName("Lee3");
		user.setPhone("010-1111-2222");
		userService.save(user);
		
	}

	@Test
	@Transactional
	public void addTest() {

		// *u : update
		userService.updateUser("010-2222-3333", (long)1);

		// *d : delete
		userService.deleteUser((long)1);

		// *r : read
		List<User> user = userService.findAll();
		for (User p : user) {
			System.out.println("~~~~~~~~UserFindAll 출력값~~~~~~~~~==>" + p.toString() + p.getName());
		}
		
		List<User> find = userService.findAllByInput("Lee");
		
		for (User p : find) {
			System.out.println("%%%%%%find 값 %%%%%%" + p.getName());
		}
		
		Assert.assertNotNull(user);

	}

}
