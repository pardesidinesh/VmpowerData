package com.krish.autodriver.resource;

import com.krish.autodriver.entity.http.ServiceInfo;
import com.krish.autodriver.processor.DashboardProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("services")
public class DashboardResource {
	
	@Autowired
	private DashboardProcessor dashboardProcessor;
	
	@GetMapping(value="/{env}", produces = "application/json")
	public List<ServiceInfo> getServiceDetails(@PathVariable("env") String env){
		return dashboardProcessor.getServiceDetails(env);
	}
	@GetMapping(value="/{env}/{serviceName}", produces = "application/json")
	public String getServiceDetails(@PathVariable("env") String env, @PathVariable("serviceName") String serviceName){
		return dashboardProcessor.loadServiceDetails(env, serviceName);
	}
	@RequestMapping(value="/metrics/{env}/{serviceName}", produces = "application/json", method = RequestMethod.GET)
	public String getServiceMetrics(@PathVariable("env") String env, @PathVariable("serviceName") String serviceName){
		return dashboardProcessor.loadServiceMetrics(env, serviceName);
	}
}
