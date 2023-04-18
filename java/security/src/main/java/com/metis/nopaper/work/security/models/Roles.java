package com.metis.nopaper.work.security.models;

import java.util.UUID;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import com.metis.nopaper.work.security.enums.ERole;
import com.metis.nopaper.work.security.models.auditing.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles", schema = "nopaperwork", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })

public class Roles extends AbstractAuditEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 5060035026126044461L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name", columnDefinition = "varchar(50)", nullable = false)
	private ERole name;

	@Column(name = "description", columnDefinition = "varchar(200)", nullable = false)
	private String description;

}
