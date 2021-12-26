package com.example.csvspringprocessing;

import com.example.csvspringprocessing.config.MyProperties;
import com.example.csvspringprocessing.config.TestProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@EnableConfigurationProperties(value = {
        TestProperties.class,
        MyProperties.class
})
@SpringBootApplication
public class Application {

    public static final String APPLICATION_LOCATIONS = "" +
            "spring.config.location=" +
            "classpath:application.yml," +
            "classpath:my-test.yml," +
            "classpath:my-settings.yml";

    public static void main(String[] args) {
//         SpringApplication.run(Application.class, args);
        new SpringApplicationBuilder(Application.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);

        // 메모리 사용량 출력
        long heapSize = Runtime.getRuntime().totalMemory();
        log.info("Heap Size(M) : " + heapSize / (1024 * 1024) + " MB");
    }

}
