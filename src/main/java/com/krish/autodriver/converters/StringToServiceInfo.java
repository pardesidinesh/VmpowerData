package com.krish.autodriver.converters;

import com.krish.autodriver.entity.http.ServiceInfo;
import org.springframework.core.convert.converter.Converter;

public class StringToServiceInfo implements Converter<String, ServiceInfo> {
    @Override
    public ServiceInfo convert(String from) {
        String[] data = from.split(" ");
        String name = data[0].replace("service:","").trim();
        String version = data[1].replace("version:","").trim();
        String status = data[2].replace("status:","").trim();
        String min_resp_time = data[3].replace("min_resp_time:","").trim();
        String avg_resp_time = data[4].replace("avg_resp_time:","").trim();
        String max_resp_time = data[5].replace("max_resp_time:","").trim();
        return new ServiceInfo(name, version, status, min_resp_time, avg_resp_time, max_resp_time);
    }
}
