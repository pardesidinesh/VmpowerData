package com.krish.autodriver.entity.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ServiceInfo {
    private String service;
    private String version;
    private String status;
    private String min_resp_time;
    private String avg_resp_time;
    private String max_resp_time;
}
