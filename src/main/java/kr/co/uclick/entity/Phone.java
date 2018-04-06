package kr.co.uclick.entity;

import javax.persistence.Column;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@Column(unique=true)
	private String phoneNumber;

	// User Entity를 참조하여  Phone 테이블에 ownerId 컬럼을 만듬
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
