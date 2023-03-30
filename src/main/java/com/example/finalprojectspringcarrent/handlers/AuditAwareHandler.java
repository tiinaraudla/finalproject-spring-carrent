package com.example.finalprojectspringcarrent.handlers;

import com.example.finalprojectspringcarrent.utils.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Tiina Raudla
 * @Date
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}
