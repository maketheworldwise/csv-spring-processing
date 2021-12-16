package com.example.csvspringprocessing;

import com.example.csvspringprocessing.config.MyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@EnableConfigurationProperties({MyProperties.class})
@SpringBootApplication
public class CsvSpringProcessingApplication {

    public static final String APPLICATION_LOCATIONS = "" +
            "classpath:application.yml," +
            "classpath:my-settings.yml";

    public static void main(String[] args) {
        // SpringApplication.run(CsvSpringProcessingApplication.class, args);
        new SpringApplicationBuilder(CsvSpringProcessingApplication.class)
                .profiles(APPLICATION_LOCATIONS)
                .run(args);

        // 메모리 사용량 출력
        long heapSize = Runtime.getRuntime().totalMemory();
        log.info("Heap Size(M) : " + heapSize / (1024 * 1024) + " MB");
    }

}
