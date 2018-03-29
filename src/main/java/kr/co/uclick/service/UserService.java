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
	
	// 입력
	public void save(User user) {
		userRepository.save(user);
	}
	// 읽기
	public List<User> findAll() {
		return userRepository.findAll();
	}
	// 수정
	public void updateUser(String name, Long id) {
		userRepository.updateUserInfoById(name, id);
	}
	// 삭제
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	// 검색으로 2명이상 조회
/*	public List<User> findAllByInput(String input) {
		return userRepository.findAllByInput(input);
	}*/
	
	public List<User> findAllByNameContaining(String name){
		return userRepository.findByNameContaining(name);
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
