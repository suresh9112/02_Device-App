package com.vvdntech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vvdntech.entity.Device;
import com.vvdntech.exception.InvalidTenant;
import com.vvdntech.service.IdeviceService;

@RestController
public class DeviceController {
	@Autowired
	private IdeviceService deviceservice;
	
	@PostMapping(value="/device",produces = "application/json",consumes = "application/json")
	ResponseEntity<String> addDevice(@RequestBody Device device,@RequestHeader int tenant_id) throws Exception
	{
	device.setTenant_id(tenant_id);
	try {
		if(device.getTenant_id()/1==device.getTenant_id()) {	
		}
	}catch(Exception e) {
		throw new InvalidTenant("Invalid_Tenant_Id");
	}
	deviceservice.add(device);
	return ResponseEntity.ok("Device valid to insert and inserted successfully");
	}
	
	@PostMapping("/showdevice/{pageNum}/{pageSize}")
	public Page<Device> findPaginated(@PathVariable(value = "pageNum") int pageNum,@PathVariable(value = "pageSize") int pageSize)
	{
		Page<Device> page = deviceservice.showPage(pageNum, pageSize);
		List<Device> list = page.getContent();

		return deviceservice.showPage(pageNum, pageSize);
	}
	
	@PutMapping("/update/{device_imei}/{device_id}")
	public Device updatedev(Device device,@PathVariable String device_imei,@RequestHeader int tenant_id,@PathVariable int device_id)
	{
		device.setDevice_imei(device_imei);
		device.setTenant_id(tenant_id);
		return deviceservice.update(device,device_id);
		
	}
	

}
