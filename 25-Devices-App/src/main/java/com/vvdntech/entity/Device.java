package com.vvdntech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
	public int device_id;
	@Size(min = 15,max = 15,message = "device imei must have size 15")
	@Pattern(regexp = "[0-9]*[1-9]",message="invalid imei")
	@Column(length=15)
	public String device_imei;
	public int tenant_id;
	public String device_name;
	public String device_model;
	public String device_fw_version;
	public String device_ipv4;
	public String device_mac;
	public int device_status;

}
