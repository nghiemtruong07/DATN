package com.example.pcthanhcongserver.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("mail")
public class MailInfoProperties {
    private String username;
    private String password;
}
