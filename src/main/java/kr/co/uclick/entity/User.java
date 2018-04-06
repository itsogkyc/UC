package kr.co.uclick.entity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = true, length = 20) // 이름 컬럼 길이 20으로 제한
	private String name;

	// OnetoMnay 다대일 관계를 정의
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // cascade : 현 Entity 변경에 대해 관계를 맺는 Entity도 변경 전략을 결정합니다.
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) // L2 Cache 적용
	private List<Phone> phone;

	public User() {
	};

	public User(String name) {
		setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	// TODO : 폰 번호를 추가함과 동시에 p Entity에 유저를 Setting
	public void addPhone(Phone p) {
		if (phone == null) {
			phone = new ArrayList<Phone>();
		}
		phone.add(p);
		p.setUser(this);
	}

}
