package kr.co.uclick.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.User;

public interface UserRepository extends JpaRepository<User, Long> { 
																	
	@Modifying
	@Transactional
	@Query("update User u set u.name = ?1 where u.id = ?2")
	public void updateUserInfoById(String name, Long id);

	@Modifying
	@Transactional
	@QueryHints(value = {  //querycache적용
	        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
	        @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
	        @QueryHint(name = "org.hibernate.cacheRegion", value = "userQueryCache")
	} )
	public List<User> findByNameContaining(String name);
	
} 