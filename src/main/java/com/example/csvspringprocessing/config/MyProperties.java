package com.example.csvspringprocessing.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("my")
public class MyProperties {

    private Path path;
    private Uri uri;

    @Getter
    @Setter
    public final static class Path {
        private String read;
        private String write;
        private String download;
    }

    @Getter
    @Setter
    public final static class Uri {
        private String s3;
        private String cdn;
    }
}
