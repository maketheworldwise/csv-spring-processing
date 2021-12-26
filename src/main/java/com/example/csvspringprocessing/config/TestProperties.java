package com.example.csvspringprocessing.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "testing")
@ConstructorBinding
public class TestProperties {
    private final String print;
}
