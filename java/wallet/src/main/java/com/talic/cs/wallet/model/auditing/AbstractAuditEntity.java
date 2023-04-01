package com.talic.cs.wallet.model.auditing;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.talic.cs.wallet.constant.WalletConstant;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -4026971765558491799L;

	@CreatedBy
	@Column(name = "created_by", nullable = false, updatable = false, columnDefinition = "varchar(200)")
	@JsonIgnore
	private String createdBy = WalletConstant.DEFAULT_ACTOR;

	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	@JsonIgnore
	private Instant createdDate = Instant.now();

	@LastModifiedBy
	@Column(name = "last_modified_by", columnDefinition = "varchar(200)")
	@JsonIgnore
	private String lastModifiedBy = WalletConstant.DEFAULT_ACTOR;

	@NotNull
	@Column(name = "status", columnDefinition = "varchar(50)")
	@JsonIgnore
	private String status = WalletConstant.DEFAULT_STATUS;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	@JsonIgnore
	private Instant lastModifiedDate = Instant.now();
}
