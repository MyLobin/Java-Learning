package com.lobin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServerConfigApp 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(ServerConfigApp.class).web(true).run(args);
    }
}
