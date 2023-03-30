package com.example.finalprojectspringcarrent.configurations;

import com.example.finalprojectspringcarrent.handlers.AuditAwareHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Tiina Raudla
 * @Date
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfigurations {
    @Bean
    public AuditorAware<String> auditorAware() {

        return (AuditorAware<String>) new AuditAwareHandler();
    }
}
