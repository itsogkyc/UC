package kr.co.uclick.phoneTest;

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
import kr.co.uclick.service.PhoneService;
import kr.co.uclick.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PhoneUpdateTest {

	@Autowired
	private PhoneService phoneService;
	@Autowired
	private UserService userService;

	@BeforeTransaction
	public void deletePhone() {

		// 테스트 유저 생성
		User user1 = new User("kim");
		User user2 = new User("lee");
		User user3 = new User("park");
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);

		// 전화기 입력
		Phone phone1 = new Phone(user1, "010-0001-0001");
		Phone phone2 = new Phone(user1, "010-0001-0002");
		Phone phone3 = new Phone(user1, "010-0001-0003");
		Phone phone4 = new Phone(user2, "010-0002-0004");
		Phone phone5 = new Phone(user3, "010-0003-0005");
		phoneService.save(phone1);
		phoneService.save(phone2);
		phoneService.save(phone3);
		phoneService.save(phone4);
		phoneService.save(phone5);

	}

	@Test
	@Transactional
	public void addTest() {

		// "010-1111-2222"로 수정
		phoneService.updatePhone("010-1111-2222", (long)1);;
		
		List<Phone> phone = phoneService.findAll();

		for (Phone p : phone) {
			System.out.println(
					"**전화기 수정 확인** =>" + " [PHONE ID]: " + p.getUser().getId() + " [PHONE NUMBER]: " + p.getPhoneNumber());
		}

	}

}
