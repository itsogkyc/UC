package kr.co.uclick.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.uclick.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
	
	public List<Phone> findAll();
	
}
