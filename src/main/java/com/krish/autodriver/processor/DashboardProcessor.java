package com.krish.autodriver.processor;

import com.krish.autodriver.configuration.ServicesList;
import com.krish.autodriver.entity.http.ServiceInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.CharEncoding.UTF_8;

@Component
public class DashboardProcessor {

    @Value("classpath:static/service-response.json")
    Resource resourceFile;

    @Autowired
    private ServicesList servicesList;

    public List<ServiceInfo> getServiceDetails(String env){
        return servicesList.getServices();
    }

    public String loadServiceDetails(String env, String serviceName){
        String str = "";
        try{
            str = FileUtils.readFileToString(resourceFile.getFile(), UTF_8);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return str;
    }

    public String loadServiceMetrics(String env, String serviceName){
        JSONObject serviceMetricsObj = new JSONObject();
        Random rdx = new Random();
        try {
            serviceMetricsObj.put("uptime", rdx.nextInt(1200));
            serviceMetricsObj.put("process", "NA");
            serviceMetricsObj.put("system", "NA");
            serviceMetricsObj.put("cpus", 2);
            serviceMetricsObj.put("gcCnt", rdx.nextInt(100));
            serviceMetricsObj.put("gcTotal", rdx.nextInt(256));
            serviceMetricsObj.put("gcMax", rdx.nextInt(250));
            serviceMetricsObj.put("heapUsed", rdx.nextInt(250));
            serviceMetricsObj.put("heapSize", rdx.nextInt(512));
            serviceMetricsObj.put("nonHeapUsed", rdx.nextInt(350));
            serviceMetricsObj.put("nonHeapSize", rdx.nextInt(1024));
            serviceMetricsObj.put("liveThreads", rdx.nextInt(50));
            serviceMetricsObj.put("daemonThreads", rdx.nextInt(80));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return serviceMetricsObj.toString();
    }
}
