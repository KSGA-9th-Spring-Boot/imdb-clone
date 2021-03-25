package io.kimleang.springmvc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileStorageConfiguration implements WebMvcConfigurer {

    @Value("${file.upload.server.path}")
    private String server;

    @Value("${file.upload.client.path}")
    private String client;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(client).addResourceLocations("file:" + server);
    }
}
