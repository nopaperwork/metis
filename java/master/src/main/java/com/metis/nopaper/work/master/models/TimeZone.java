package com.metis.nopaper.work.master.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.metis.nopaper.work.master.enums.EZone;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "time_zone", schema = "nopaperwork")
public class TimeZone extends AbstractAuditEntity {

	private static final long serialVersionUID = -1519111434616921517L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(length = 200, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private String code;

	@Enumerated(EnumType.STRING)
	@Column(name = "zone", columnDefinition = "varchar(50)", nullable = false)
	private EZone zone;

	@Column(nullable = false)
	private Integer difference;
	
	@Type(ListArrayType.class)
	@Column(
	    name = "alias_name",
	    columnDefinition = "text[]"
	)
	private List<String> aliasName;

}