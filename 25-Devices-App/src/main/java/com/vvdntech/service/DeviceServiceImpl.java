package com.vvdntech.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vvdntech.dao.DeviceDao;
import com.vvdntech.entity.Device;
import com.vvdntech.exception.InvalidImeiException;

@Service("deviceservice")
public class DeviceServiceImpl implements IdeviceService {
	
	@Autowired
	private DeviceDao dao;
	@Override
	public Device add(Device dev) throws Exception {
		Device device=new Device();
		device.setDevice_fw_version(dev.getDevice_fw_version());
		device.setDevice_imei(dev.getDevice_imei());
		device.setDevice_ipv4(dev.getDevice_ipv4());
		device.setDevice_mac(dev.getDevice_mac());
		device.setDevice_model(dev.getDevice_model());
		device.setDevice_name(dev.getDevice_name());
		device.setDevice_status(1);
		device.setTenant_id(dev.getTenant_id());
		findByImei(dev.getDevice_imei());
		int length=device.getDevice_imei().length();
		if(length==15)
		{
			try
		{
			long imei = Long.parseLong(device.getDevice_imei());
		}catch(Exception e) {
		     throw new InvalidImeiException("INVALID_DEVICE_IMEI");
		}
		}
		else {
		throw new InvalidImeiException("INVALID_DEVICE_IMEI");
		}
			if(findByImei(device.getDevice_imei()))
			{
			throw new InvalidImeiException("Invalid Device Imei");
		}
		dao.save(device);
		return device;
		
	}
	boolean status;
	public Boolean findByImei(String Imei) throws Exception
	{
		List<String> findImei = dao.findByImei();
		findImei.forEach(device_imei->{
			if(device_imei.equals(Imei))
			{
			status=true;
			}
			else {
				status=false;
			}
		});
		return status;
	}
	 
 public Device update(Device dev,int device_id)
 {
	
		 dev.setDevice_fw_version(dev.getDevice_fw_version());
			dev.setDevice_ipv4(dev.getDevice_ipv4());
			dev.setDevice_mac(dev.getDevice_mac());
			dev.setDevice_model(dev.getDevice_model());
			dev.setDevice_name(dev.getDevice_name());
			return dao.save(dev);
	 }
	    
@Override
public Page<Device> showPage(int pageNum, int pageSize) {
	// TODO Auto-generated method stub
	PageRequest request = PageRequest.of(pageNum - 1, pageSize);
	return this.dao.findAll(request);
}
}
