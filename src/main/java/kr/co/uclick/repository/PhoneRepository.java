package kr.co.uclick.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

	public List<Phone> findAll();

	public void deleteByphoneNumber(String phoneNumber);

	@Modifying
	@Transactional
	@Query("update Phone p set p.phoneNumber = ?1 where p.seq = ?2")
	public void updatePhoneInfoById(String name, Long phoneId);

	@Modifying
	@Transactional
	@QueryHints(value = {   //querycache적용
	        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
	        @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
	        @QueryHint(name = "org.hibernate.cacheRegion", value = "phoneQueryCache")
	} )
	public List<Phone> findByphoneNumberContaining(String phoneNumber);

}
