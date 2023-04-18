package com.metis.nopaper.work.security.models;

import java.util.UUID;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import com.metis.nopaper.work.security.enums.TokenType;
import com.metis.nopaper.work.security.models.auditing.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_token", schema = "nopaperwork", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "user_id", "token" }) })
public class UserToken extends AbstractAuditEntity {

	private static final long serialVersionUID = -692270973159056237L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(name = "token", columnDefinition = "varchar(512)", unique = true, nullable = false)
	private String token;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "varchar(20)", nullable = false)
	@Builder.Default
	private TokenType tokenType = TokenType.BEARER;

	@Column(name = "revoked", nullable = false)
	@Builder.Default
	private boolean revoked = true;

	@Column(name = "expired", nullable = false)
	@Builder.Default
	private boolean expired = true;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
}