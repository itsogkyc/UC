package kr.co.uclick.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Table;
import org.springframework.cache.annotation.Cacheable;

@Entity 
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Phone {
	
	@Id   //식별자  일반적으로 PK를 가지는 변수에 선언 
	@GeneratedValue(strategy = GenerationType.AUTO)	// 해당 ID값을 어떻게 자동으로 생성할지 선택 (자동증가)
	private Long seq;

	private Long ownerId;
	
	private String phoneNumber;
	
	public Phone() {}
	
	public Phone(String phone) {
		phoneNumber = phone;
	}
	

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	
}
