package kr.co.uclick.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Phone {

	@Id // 식별자 일반적으로 PK를 가지는 변수에 선언
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 ID값을 어떻게 자동으로 생성할지 선택 (자동증가)
	private Long seq;

	private String phoneNumber;

	// User Entity를 참조하여 ownerId 컬럼을 만듬
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerId")
	private User user;

	public Phone() {
	}

	public Phone(User user, String phoneNumber) {
		this.user = user;
		this.phoneNumber = phoneNumber;
	}

	public Phone(String phone) {
		phoneNumber = phone;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
