package com.ecomm.models;

import javax.persistence.*;

import java.io.Serializable;

@MappedSuperclass
@SuppressWarnings("serial")
public class BaseEntity implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT")
	private Integer id;

	public long getId() { return id; }
	public void setId(Integer id) { this.id = id; }
}

