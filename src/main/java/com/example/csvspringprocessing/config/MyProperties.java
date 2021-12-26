package com.example.csvspringprocessing.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties("my")
public final class MyProperties {

    private final Paths paths;
    private final Uris uris;

    @Getter
    @RequiredArgsConstructor
    public static final class Paths {
        private final String read;
        private final String write;
        private final String download;
    }

    @Getter
    @RequiredArgsConstructor
    public static final class Uris {
        private final String s3;
        private final String cdn;
    }
}
