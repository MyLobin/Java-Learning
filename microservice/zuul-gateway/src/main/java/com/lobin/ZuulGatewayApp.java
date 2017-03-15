package com.lobin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApp 
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(ZuulGatewayApp.class).web(true).run(args);
    }
}
