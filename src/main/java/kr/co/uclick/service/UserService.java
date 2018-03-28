package kr.co.uclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.User;
import kr.co.uclick.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//C
	public void save(User user) {
		userRepository.save(user);
	}
	//R
	public List<User> findAll() {
		return userRepository.findAll();
	}
	//U
	public void updateUser(String phone, Long userId) {
		userRepository.updateUserInfoById(phone, userId);
	}
	//D
	public void deleteUser(Long userId) {
		userRepository.deleteUserById(userId);
	}
	
	public List<User> findAllByInput(String input) {
		return userRepository.findAllByInput(input);
	}
	
	
/*	@SuppressWarnings("unchecked")
	public List<User> findAllByInput(String input) {
		System.out.println("단계1");
		entityManager = emf.createEntityManager();
		System.out.println("단계2");
		List<User> value = entityManager.createQuery("select u from User u where u.name like %"+input+"%")
		  .setHint("org.hibernate.cacheable", true)
		  .getResultList();
		System.out.println("단계3");
		return value;
	}*/
	
	
}
