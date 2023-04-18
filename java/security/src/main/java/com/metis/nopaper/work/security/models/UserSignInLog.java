package com.metis.nopaper.work.security.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metis.nopaper.work.security.constant.SecurityConstant;
import com.metis.nopaper.work.security.enums.ERole;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_signin_log", schema = "nopaperwork")
public class UserSignInLog implements Serializable {

	private static final long serialVersionUID = 4248069385343102397L;

	/**
	 *
	 */

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	private UUID userId;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "identity", columnDefinition = "varchar(100)", nullable = false)
	private String identity;

	@NotBlank
	@Size(max = 50)
	@Column(name = "username", columnDefinition = "varchar(50)", nullable = false)
	private String username;

	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "email", columnDefinition = "varchar(100)", nullable = false)
	private String email;

	@NotBlank
	@Size(max = 20)
	@Column(name = "mobile", columnDefinition = "varchar(20)", nullable = false)
	private String mobile;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "varchar(20)", nullable = false)
	private ERole role;

	@Column(name = "userAgent", columnDefinition = "varchar(512)", nullable = false)
	private String userAgent = "-";

	@Column(name = "deviceCode", columnDefinition = "varchar(512)", nullable = false)
	private String deviceCode = "-";

	@Column(name = "ip", columnDefinition = "varchar(512)", nullable = false)
	private String ip = "-";

	@Column(name = "timeZone", columnDefinition = "varchar(512)", nullable = false)
	private String timeZone = "-";

	@Type(JsonType.class)
	@Column(columnDefinition = "jsonb")
	private Map<String, String> headerValue = new HashMap<>();
	
	@NotBlank
	@Column(name = "accessToken", columnDefinition = "varchar(512)", nullable = false)
	private String accessToken;
	
	@CreatedBy
	@Column(name = "created_by", nullable = false, updatable = false, columnDefinition = "varchar(200)")
	@JsonIgnore
	private String createdBy = SecurityConstant.DEFAULT_ACTOR;

	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	@JsonIgnore
	private Instant createdDate = Instant.now();

	@NotNull
	@Column(name = "status", columnDefinition = "varchar(50)")
	@JsonIgnore
	private String status = SecurityConstant.DEFAULT_STATUS;
}
