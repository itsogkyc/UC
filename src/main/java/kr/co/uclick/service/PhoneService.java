package kr.co.uclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.User;
import kr.co.uclick.repository.PhoneRepository;

@Service
@Transactional
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;
	
	public void save(User user) {
		phoneRepository.save(user);
	}
	//R
	public List<User> findAll() {
		return phoneRepository.findAll();
	}
	//U
	public void updateUser(String phone, Long userId) {
		phoneRepository.updateUserInfoById(phone, userId);
	}
	//D
	public void deleteUser(Long userId) {
		phoneRepository.deleteUserById(userId);
	}
	
	public List<User> findAllByInput(String input) {
		return phoneRepository.findAllByInput(input);
	}
	
	
	
}
