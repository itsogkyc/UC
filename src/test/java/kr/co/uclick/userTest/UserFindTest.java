package kr.co.uclick.userTest;

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
import kr.co.uclick.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserFindTest {

	@Autowired
	private UserService userService;

	@BeforeTransaction
	public void addUser() {

		User user1 = new User();
		user1.setName("kim young chul");
		user1.addPhone(new Phone("010-0000-0001"));
		user1.addPhone(new Phone("010-0000-0002"));
		userService.save(user1);

		User user2 = new User();
		user2.setName("kim bo gum");
		user2.addPhone(new Phone("010-0000-0003"));
		user2.addPhone(new Phone("010-0000-0004"));
		userService.save(user2);

		User user3 = new User();
		user3.setName("kim dae bak");
		user3.addPhone(new Phone("010-0000-0005"));
		user3.addPhone(new Phone("010-0000-0006"));
		userService.save(user3);

	}

	@Test
	@Transactional
	public void addTest() {

		List<User> user = userService.findAllByNameContaining("kim");

		// 성이 kim인 사용자 조회
		for (User u : user) {
			System.out.println("**사용자 조회값 확인** =>" + " [ID]: " + u.getId() + " [NAME]: " + u.getName());
		}

		Assert.assertEquals("kim young chul", user.get(0).getName());

	}

}
