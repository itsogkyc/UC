package kr.co.uclick.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserAddTest {

	@Autowired
	private UserService userService;

	@BeforeTransaction
	public void addUser() {
		User user = new User();
		user.setName("kim");
		userService.save(user);
	}

	@Test
	@Transactional
	public void addTest() {
		User user = userService.findByName("kim");
		Assert.assertNotNull(user);
	}

}
