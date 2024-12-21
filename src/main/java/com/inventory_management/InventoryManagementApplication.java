package com.inventory_management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class InventoryManagementApplication implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;
    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Run method begging");
        log.info("Issuer URI: {}", issuerUri);
        log.info("JWK Set: {}", jwkSetUri);
        log.info("dbUrl Set: {}", dbUrl);
    }
}
