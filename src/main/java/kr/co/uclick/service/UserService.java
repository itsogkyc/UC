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
		
		// 이름 20byte로 제한
		int nameByte = user.getName().getBytes().length;
		if(nameByte <= 20) {
			userRepository.save(user);
		}else {
			System.out.println("**Error Log** => 사용자 이름 20byte제한 초과  [입력byte] : " + nameByte);
		}
		
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
	// 특정 사용자 조회
	public List<User> findAllByNameContaining(String name){
		return userRepository.findByNameContaining(name);
	}
	
}
