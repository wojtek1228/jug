package com.example.jug.jugdemo;

import org.apache.camel.CamelContext;
import org.apache.camel.component.google.drive.GoogleDriveComponent;
import org.apache.camel.component.google.drive.GoogleDriveConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class GoogleConfig {

    @Autowired
    private CamelContext camelContext;

    private List<String> scope = Arrays.asList("https://www.googleapis.com/auth/drive.file");

    @Bean
    public CamelContextConfiguration camelContextConfiguration(){
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext camelContext) {
                GoogleDriveConfiguration config = new GoogleDriveConfiguration();
                config.setApplicationName("jug-gdrive");
                config.setClientId("20148417749-pgopb3k6vbfuiviiippj3umn7kk0bh0v.apps.googleusercontent.com");
                config.setClientSecret("etertb_T3RyRQYNIOgxvlfxA");
             //   config.setAccessToken("ya29.GlscB-5cg9rdpANGEYDH3yInG1stUAHn6fmGCfOShlGKJrjLZoq3f0Zeb4Fvq8iYijxUl4qzdYVdZH7WmqQ6qE3GQZhaoYgfeq0N_0JdkaR-nPL_ar0O7A5hhzbg");
                config.setRefreshToken("1/BFn0-faFCfcADSCGDv3fDuYsFbcF6GVKE1YV1EbjJzw");

                GoogleDriveComponent component = new GoogleDriveComponent();
                component.setConfiguration(config);
                camelContext.addComponent("google-drive", component);

            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {

            }
        };
    }
}
