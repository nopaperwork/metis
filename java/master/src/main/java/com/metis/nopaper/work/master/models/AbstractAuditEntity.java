package com.metis.nopaper.work.master.models;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metis.nopaper.work.master.constant.MasterConstant;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = 9043753375678468768L;

	@CreatedBy
	@Column(name = "created_by", nullable = false, updatable = false, columnDefinition = "varchar(200)")
	@JsonIgnore
	private String createdBy = MasterConstant.DEFAULT_ACTOR;

	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	@JsonIgnore
	private Instant createdDate = Instant.now();

	@LastModifiedBy
	@Column(name = "last_modified_by", columnDefinition = "varchar(200)")
	@JsonIgnore
	private String lastModifiedBy = MasterConstant.DEFAULT_ACTOR;

	@Column(name = "status", columnDefinition = "varchar(50)")
	@JsonIgnore
	private String status = MasterConstant.DEFAULT_STATUS;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	@JsonIgnore
	private Instant lastModifiedDate = Instant.now();
}
