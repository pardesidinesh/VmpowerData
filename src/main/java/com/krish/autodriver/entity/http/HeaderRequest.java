package com.krish.autodriver.entity.http;

import lombok.Getter;
import lombok.Setter;

public class HeaderRequest {
    private @Getter @Setter String environment;
    private @Getter @Setter String serviceName;
    private @Getter @Setter String endPoint;
}
