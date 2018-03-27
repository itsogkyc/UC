package kr.co.uclick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.QUser;
import kr.co.uclick.entity.User;
import kr.co.uclick.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
		userRepository.findAll(QUser.user.name.eq(user.getName()));
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	
}
