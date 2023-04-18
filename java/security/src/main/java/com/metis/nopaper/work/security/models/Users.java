package com.metis.nopaper.work.security.models;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metis.nopaper.work.security.enums.ERole;
import com.metis.nopaper.work.security.models.auditing.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "nopaperwork", uniqueConstraints = { @UniqueConstraint(columnNames = {"email", "status"}) })
public class Users extends AbstractAuditEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1744595246266252533L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "username", unique = true, columnDefinition = "varchar(50)", nullable = false)
	private String username;

	@NotBlank
	@Size(max = 100)
	@Email
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	@Column(name = "email", unique = true, columnDefinition = "varchar(100)", nullable = false)
	private String email;

	@NotBlank
	@Size(max = 20)
	@Column(name = "mobile", columnDefinition = "varchar(20)", nullable = false)
	private String mobile;

	@NotBlank
	@Column(name = "password", columnDefinition = "varchar(512)", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "varchar(20)", nullable = false)
	private ERole role;
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_authority_map", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName="id"), 
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName="id"))
	private Set<UserAuthorities> userAuthorities = new HashSet<>();
	
	@Column(name = "deviceCode", columnDefinition = "varchar(512)", nullable = false)
	private String deviceCode = "-";
	
	@Column(name = "ip", columnDefinition = "varchar(512)", nullable = false)
	private String ip = "-";
	
	@Column(name = "timeZone", columnDefinition = "varchar(512)", nullable = false)
	private String timeZone = "-";
	
	@Type(JsonType.class)
	@Column(columnDefinition = "jsonb")
    private Map<String, String> headerValue;

}
