package com.example.jug.jugdemo;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.model.File;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class FileProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        File metaData = new File();
        metaData.setTitle(exchange.getIn().getBody(java.io.File.class).getName());

        FileContent content = new FileContent(null, exchange.getIn().getBody(java.io.File.class));

        Map<String, Object> headers = new HashMap<>();
        headers.put("CamelGoogleDrive.content", metaData);
        headers.put("CamelGoogleDrive.mediaContent", content);

        exchange.getOut().getHeaders().putAll(headers);
    }
}
