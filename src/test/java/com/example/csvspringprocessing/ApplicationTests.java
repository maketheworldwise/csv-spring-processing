package com.example.csvspringprocessing;

import com.example.csvspringprocessing.config.MyProperties;
import com.example.csvspringprocessing.config.TestProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class ApplicationTests {

    @Autowired
    TestProperties testProperties;

    @Autowired
    MyProperties myProperties;

    static {
        System.setProperty("spring.config.location", "classpath:application.yml,classpath:my-test.yml,classpath:my-settings.yml");
    }

    @DisplayName("TestProperties bind 테스트")
    @Test
    void contextLoads() {
        assertThat(testProperties.getPrint(), is(equalTo("Hello-world")));
    }
}
