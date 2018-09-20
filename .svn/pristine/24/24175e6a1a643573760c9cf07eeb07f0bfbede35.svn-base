package com.zhy.modules.job.task;

/**
 * Copyright 2018 智慧云
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import com.zhy.modules.sys.entity.SysUserEntity;
import com.zhy.modules.sys.service.SysUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试多线程批量发起数据采集
 * 同时采集多个回路的数据
 *
 * testTask为spring bean的名称
 *
 * @author Mark 
 * @since 1.2.0 2016-11-28
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysUserService sysUserService;
	
	public void test(String params){
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SysUserEntity user = sysUserService.selectById(1L);
		System.out.println(ToStringBuilder.reflectionToString(user));
		
	}
	
	/**
	 * 
	 * 假设 同时去采集20（N）个电表的数据,这个根据某个厂家下的电表的数量灵活配置，
	 * 采用如下代码
	 * 建议同设备且同频率采集的的同结果的数据，放一个task里
	 * 下午11:02:16
	 */
	public void test2(){
		 List<String>  electricityMeters=new ArrayList<String>();
		 electricityMeters.add("id1");
		 electricityMeters.add("id2");//存放电表的地址，ID信息
		 electricityMeters.add("id3");
		 electricityMeters.add("id4");
		 electricityMeters.add("id5");
		 /*** 20 个  ***/
	    List<Future<Object>> futureResults = new ArrayList<Future<Object>>(); 
		 ExecutorService threadpool = Executors.newFixedThreadPool(electricityMeters.size() );
       for (String  MeterAdressAndId: electricityMeters) {
			//这里应该是 采集数据的 代码  
    	     GatherSingle  gatherDateSingle=new GatherSingle(MeterAdressAndId);
			 futureResults.add(threadpool.submit( gatherDateSingle));
		}
	
	
	
	}

	  /**
	   * 
	   * @author xtp
	   * 智能运维平台- GatherSingle
	   * 2018年8月31日
	   *下午11:26:24
	   */
	  public class GatherSingle implements Callable<Object> {// 多线程取值
	  		private String object;

	  		public GatherSingle(String object) {
	  			this.object = object;
	  		}
	  		@Override
	  		public Object call() throws Exception {
	  			if (object == null) {
	  				throw new NullPointerException("object对象为空");
	  			}
	  			return gatherData(object);
	  		}
	  	}
	  
	  /**
	   * 采集数据的方法
	   * @param object
	   * @return
	   * 上午12:03:47
	   */
	  private String gatherData(String object) {
		      int b=0;
	    	   for(int a=0;a<1000000;a++){
	    		    b+=a;
	    	   }
	    	  System.err.println("当前采集数据的线程："+Thread.currentThread().getName()+"-"+System.currentTimeMillis());
	    	  return "";
	      }	
     
}
