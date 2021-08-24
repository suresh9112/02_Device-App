package com.vvdntech.service;

import org.springframework.data.domain.Page;

import com.vvdntech.entity.Device;

public interface IdeviceService {
	
	public Device add(Device device) throws Exception;
    public Device update(Device device,int device_id);
    public Page<Device> showPage(int pageNo,int pageSize);
}

