package kr.co.uclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.repository.PhoneRepository;

@Service
@Transactional
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	// 입력
	public void save(Phone phone) {
		phoneRepository.save(phone);
	}
	// 읽기
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}
	// 수정
	public void updatePhone(String phoneNumber, Long phoneId) {
		phoneRepository.updatePhoneInfoById(phoneNumber, phoneId);
	}
	// 삭제
	public void deletePhone(String phoneNumber) {
		phoneRepository.deleteByphoneNumber(phoneNumber);
	}
	// 찾기
	public List<Phone> findUserByPhoneNumber(String phoneNumber){
		return phoneRepository.findByphoneNumberContaining(phoneNumber);
	}
	
}
