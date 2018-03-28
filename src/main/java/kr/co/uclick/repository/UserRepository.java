package kr.co.uclick.repository;



import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {		//JpaRepository가 CrudRepository보다 상위 클래스임
																		// <Entity, Entity의 Id 데이터 타입>
	@Modifying
	@Transactional
	@Query("update User u set u.phone = ?1 where u.id = ?2")
	public void updateUserInfoById(String phone, Long userId);

	@Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id=:id")
    public void deleteUserById(@Param("id") Long userId);

	@Modifying
    @Transactional
	@Query("select u from User u where u.name like %:input%")
    public List<User> findAllByInput(@Param("input") String input);
	
	
	
}

