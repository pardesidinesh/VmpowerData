package com.krish.autodriver.processor;

import com.krish.autodriver.configuration.ServicesList;
import com.krish.autodriver.entity.http.HeaderRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.CharEncoding.UTF_8;

@Component
public class SwaggerProcessor {
    @Value("classpath:static/swagger.json")
    private Resource resourceFile;

    @Value("classpath:static/payment-ui.png")
    private Resource flowResource;

    @Autowired
    private ServicesList servicesList;

    public List<String> getServiceList(String env){
        List<String> services = new ArrayList<>();
        servicesList.getServices().forEach(x -> services.add(x.getService()));
        return services;
    }

    public List<String> loadEndpoints(String env, String serviceName){
        List<String> endpoints = new ArrayList<>();
        try{
            String str = FileUtils.readFileToString(resourceFile.getFile(), UTF_8);
            JSONObject swaggerJson = new JSONObject(str);
            JSONObject endpointsObj = swaggerJson.optJSONObject("paths");
            Iterator<String> itr = endpointsObj.keys();
            while(itr.hasNext()){
                endpoints.add(itr.next());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return endpoints;
    }

    public String getFlowImage(String serviceNm){
        String encodedString = "";
        try{
            byte[] fileContent = FileUtils.readFileToByteArray(flowResource.getFile());
            encodedString = Base64.getEncoder().encodeToString(fileContent);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return encodedString;
    }

    public String getHeaders(HeaderRequest headerReq){
        String resp = "";
        try {
            JSONObject hedrs = new JSONObject();
            hedrs.put("X-Request-ID", "2dc6ea89-222b-49b1-9d34-44df7f045879");
            hedrs.put("Cache-Control", "no-cache");
            hedrs.put("Accept", "application/json");
            hedrs.put("Content-Type", "application/json");
            hedrs.put("Accept-Encoding", "gzip, deflate, br");
            hedrs.put("User-Access-Token", "2dc6ea89-222b-49b1-9d34-44df7f045879");
            hedrs.put("Content-Type", "application/json");
            resp = hedrs.toString();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resp;
    }
}
