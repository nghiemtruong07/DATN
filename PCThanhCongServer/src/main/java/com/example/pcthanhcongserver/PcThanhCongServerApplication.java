package com.example.pcthanhcongserver;

import com.example.pcthanhcongserver.configs.MailInfoProperties;
import com.example.pcthanhcongserver.configs.StorageProperties;
import com.example.pcthanhcongserver.services.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Slf4j
@EnableConfigurationProperties({MailInfoProperties.class, StorageProperties.class, MailInfoProperties.class})

public class PcThanhCongServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcThanhCongServerApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(IStorageService storageService){
//        return (args -> {
//            storageService.init();
//        });
//    }
}
