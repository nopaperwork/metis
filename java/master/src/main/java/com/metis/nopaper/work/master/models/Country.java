package com.metis.nopaper.work.master.models;

import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "country", schema = "nopaperwork")
public class Country extends AbstractAuditEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5817513820716338530L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(length = 200, nullable = false, unique = true)
	private String name;

	@Column(length = 50, nullable = false, unique = true)
	private String code;
	
	@Column(length = 5, nullable = false, unique = true)
	private String telephoneCode;
	
	@Column
	private UUID timeZoneId;
	
	@Column
	private UUID currencyId;

}

