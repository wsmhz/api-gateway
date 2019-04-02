package com.wsmhz.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//    @ConfigurationProperties("zuul")
//    @RefreshScope
//    public ZuulProperties zuulProperties() {
//        return new ZuulProperties();
//    }
}
