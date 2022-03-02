package com.krish.autodriver.resource;

import com.krish.autodriver.entity.http.HeaderRequest;
import com.krish.autodriver.processor.SwaggerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("swagger")
public class SwaggerResource {
    @Autowired
    private SwaggerProcessor swaggerProcessor;

    @GetMapping(value="/{env}", produces = "application/json")
    public List<String> getServiceDetails(@PathVariable("env") String env){
        return swaggerProcessor.getServiceList(env);
    }

    @GetMapping(value="/{env}/{serviceName}", produces = "application/json")
    public List<String> getServiceEndpoints(@PathVariable("env") String env, @PathVariable("serviceName") String serviceName){
        return swaggerProcessor.loadEndpoints(env, serviceName);
    }

    @RequestMapping(value="/{serviceName}/ui", produces = "application/json", method = RequestMethod.GET)
    public String getServiceFlow(@PathVariable("serviceName") String serviceName){
        return swaggerProcessor.getFlowImage(serviceName);
    }

    @RequestMapping(value="/headers", produces = "application/json", method = RequestMethod.POST)
    public String getServiceHeaders(@RequestBody HeaderRequest headerReq){
        return swaggerProcessor.getHeaders(headerReq);
    }


}
