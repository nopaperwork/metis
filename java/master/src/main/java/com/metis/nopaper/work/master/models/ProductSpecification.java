package com.metis.nopaper.work.master.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@DynamicInsert
@DynamicUpdate
@Table(name = "product_specification", schema = "nopaperwork", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "code")
		})
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ProductSpecification extends AbstractAuditEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8396162546546973655L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	/*
	 * @Type(type = "jsonb")
	 * @Column(columnDefinition = "jsonb")
	 * private Map<String, String> properties = new HashMap<>();
	 */
	
	
	@Column(length = 200, nullable = false)
	private String name;

	@Column(length = 5000, nullable = false)
	private String description;
	
	@Column(length = 300, nullable = false)
	private String value;

	@Column(length = 50, nullable = false)
	private String code;

	@Type(ListArrayType.class)
	@Column(
	    name = "alias_name",
	    columnDefinition = "text[]"
	)
	private List<String> aliasName;
	
	@Column
	private UUID productId;
}
