package com.zhy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhy.modules.*.dao"})
public class AdminApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		 SpringApplication.run(AdminApplication.class, args);
 		//SpringApplication newRun= new SpringApplication(AdminApplication.class); 
//		newRun.setBannerMode(Banner.Mode.OFF);
//		newRun.run(args);
// 		Collector collector = new Collector();
// 		collector.init();
//		collector.start();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdminApplication.class);
	}
}
