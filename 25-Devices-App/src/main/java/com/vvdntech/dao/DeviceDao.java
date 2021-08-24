package com.vvdntech.dao;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vvdntech.entity.Device;

@Repository
public interface DeviceDao extends JpaRepository<Device, Serializable> {
	@Query("select device_imei from Device")
  public List<String> findByImei();
	
}
