package com.yxldev.lottstate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.yxldev.lottstate.config")
public class LottStat {
    public static void main(String[] args) {
        log.info("** Starting LottStat application **");
        SpringApplication.run(LottStat.class, args);
    }
}