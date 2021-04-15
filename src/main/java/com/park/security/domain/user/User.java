package com.park.security.domain.user;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.park.security.utils.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
	
	// primary key, auto increment setting
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true, unique = true)
	private String username;
	
	@Column(nullable = true)
	private String password;
	
	// DB에 권한을 문자열로 저장하기 위한 어노테이션 입니다.
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreatedDate
	private Timestamp createDate;

}
