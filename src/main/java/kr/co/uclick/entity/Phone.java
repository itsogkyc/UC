package kr.co.uclick.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity 
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Phone {
	
	@Id   //DB PK와 매핑할 필드	, 일반적으로 PK를 가지는 변수에 선언 
	@GeneratedValue(strategy = GenerationType.AUTO)	// 해당 ID값을 어떻게 자동으로 생성할지 선택
	private Long seq;

	private Long userId;
	
	private String phoneNumber;
	
	
	public Phone() {}
	public Phone(String no){
		this.phoneNumber = no;
	}
	
	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

		
	
	
	
}
