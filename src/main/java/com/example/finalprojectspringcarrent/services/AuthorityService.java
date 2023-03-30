package com.example.finalprojectspringcarrent.services;

import com.example.finalprojectspringcarrent.exceptions.AuthorityNotFoundException;
import com.example.finalprojectspringcarrent.models.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
public interface AuthorityService {
    /**
     * To fina all authorities
     *
     * @return a list of authorities
     */
    List<Authority> findAllAuthorities();

    /**
     * To find authority by name
     *
     * @param name Authority name
     * @return Authority
     */
    Authority findAuthorityByName(String name) throws AuthorityNotFoundException;

    /**
     * To create a new authority
     *
     * @param authority Authority
     */
    void createAuthority(Authority authority);
}
