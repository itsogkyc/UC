package kr.co.uclick.userTest;

import java.util.List;

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
public class UserUpdateTest {

	@Autowired
	private UserService userService;

	@BeforeTransaction
	public void addUser() {

		User user1 = new User();
		user1.setName("kim");
		user1.addPhone(new Phone("010-0000-0001"));
		user1.addPhone(new Phone("010-0000-0002"));
		userService.save(user1);

		User user2 = new User();
		user2.setName("lee");
		user2.addPhone(new Phone("010-0000-0003"));
		user2.addPhone(new Phone("010-0000-0004"));
		userService.save(user2);
		
		User user3 = new User();
		user3.setName("park");
		user3.addPhone(new Phone("010-0000-0005"));
		user3.addPhone(new Phone("010-0000-0006"));
		userService.save(user3);
		
	}

	@Test
	@Transactional
	public void addTest() {
		
		//update
		userService.updateUser("나의 이름은 20byte가 넘습니다.", (long)1);   //수정할 이름이 20byte넘을시 수정취소
		userService.updateUser("updatedLee", (long)2);
		userService.updateUser("updatedPark", (long)3);
		List<User> user = userService.findAll();
		
		for (User c : user) {
			System.out.println("**사용자 수정 확인** =>" + " [ID]: " + c.getId() + " [NAME]: " + c.getName());
		}

	}

}
