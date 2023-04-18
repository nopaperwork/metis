package com.metis.nopaper.work.master.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.metis.nopaper.work.master.enums.ENatureOfBusiness;
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
@Table(name = "nature_of_business", schema = "nopaperwork")
public class NatureOfBusiness extends AbstractAuditEntity {

	private static final long serialVersionUID = -114035499108929985L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name", columnDefinition = "varchar(50)", nullable = false, unique = true)
	private ENatureOfBusiness name;

	@Column(name = "description", columnDefinition = "varchar(200)", nullable = false)
	private String description;

	@Column(length = 50, nullable = false, unique = true)
	private String code;
	
	@Type(ListArrayType.class)
	@Column(
	    name = "alias_name",
	    columnDefinition = "text[]"
	)
	private List<String> aliasName;

}
