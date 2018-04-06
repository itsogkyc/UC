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
		boolean check = checkNameByte(user.getName());
		if(check==false) {
			return;
		}
		userRepository.save(user);
	}
	
	// 읽기
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	// 수정
	public void updateUser(String name, Long id) {
		boolean check = checkNameByte(name);
		if(check==false) {
			return;
		}
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
	
	// 입력값(이름) byte 체크
	public boolean checkNameByte(String name) {
		if(name.getBytes().length > 20) {
			System.out.println("** 에 러 ** => 입력하신 이름이 20byte 초과하셨습니다");
			return false;
		}
		return true;
	}
	
}
