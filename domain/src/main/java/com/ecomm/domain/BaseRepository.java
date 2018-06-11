package com.ecomm.domain;

import com.ecomm.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Serializable>
{
}
