package com.example.jug.jugdemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SynchroRoute extends RouteBuilder {

    @Autowired
    private FileProcessor fileProcessor;

    @Override
    public void configure() throws Exception {
        from("file://C:/OCR/wp?delete=true")
        .process(fileProcessor)
        .to("google-drive://drive-files/insert");
    }
}
