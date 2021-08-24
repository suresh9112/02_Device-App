package com.vvdntech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vvdntech.dao.DeviceDao;
import com.vvdntech.entity.Device;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		/*ConfigurableApplicationContext con=*/SpringApplication.run(Application.class, args);
		//DeviceDao bean=(DeviceDao)con.getBean(DeviceDao.class);
		
		/*Device d=new Device();
		d.setDevice_fw_version("1.322");
		d.setDevice_imei("123456789098765");
		d.setDevice_ipv4("127.0.0.190");
		d.setDevice_mac("a1:12:12:11:b1:90");
		d.setDevice_model("samsung");
		d.setDevice_name("f34");
		bean.save(d);
		System.out.println(d);*/
	}

}
