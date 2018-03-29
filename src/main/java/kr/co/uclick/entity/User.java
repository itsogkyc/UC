package kr.co.uclick.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity // JPA의 엔티티는 테이블을 객체로 표현한 자바 클래스이다
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {

	@Id // DB PK와 매핑할 필드
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = true, length = 20) // 이름 컬럼 20byte제한 (*체크)
	private String name;


/*    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phone;*/
	
	
	//1번쨰 케이스
	//@JoinColumn은 외래키매핑용이며 name은 자기자신 테이블(table)의 컬럼명
	//@OneToMany 사용자는 여러개의 전화기를 갖고 있기 때문에 List, Collection 형식으로 여러 값을 받게 된다
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)		//cascade : 현 Entity 변경에 대해 관계를 맺는 Entity도 변경 전략을 결정합니다.
	@JoinColumn(name="ownerId", referencedColumnName="id")		// Phone엔터티에서 참조할 변수이름
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private List<Phone> phone;


	public User() {
	};

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
	
	public boolean addPhone(Phone p){
		if( phone == null ){
			phone = new ArrayList<Phone>();
		}
		return phone.add(p);
	}

	/*
	 * public Collection<Phone> getPhone() { return phone; }
	 * 
	 * public void setPhone(List<Phone> phone) { this.phone = phone; }
	 */

}
