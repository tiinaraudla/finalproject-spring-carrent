package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.AuthorityNotFoundException;
import com.example.finalprojectspringcarrent.models.Authority;
import com.example.finalprojectspringcarrent.repositories.AuthorityRepository;
import com.example.finalprojectspringcarrent.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Tiina Raudla
 * @Date
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public List<Authority> findAllAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority findAuthorityByName(String name) throws AuthorityNotFoundException {
        Optional<Authority> optionalAuthority = authorityRepository.findByName(name);

        if(optionalAuthority.isEmpty()) {
            throw new AuthorityNotFoundException(name);
        }

        return optionalAuthority.get();
    }

    @Override
    public void createAuthority(Authority authority) {
        authority.setActive(true);
        authorityRepository.save(authority);

    }
}
