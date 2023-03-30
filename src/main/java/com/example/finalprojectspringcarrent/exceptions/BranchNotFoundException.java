package com.example.finalprojectspringcarrent.exceptions;

/**
 * @author Tiina Raudla
 * @Date
 */
public class BranchNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public BranchNotFoundException(Long date) {
        super(String.format("Branch not found for date: %d", date));
    }
    public BranchNotFoundException (String clientName) {
        super(String.format("Branch not found for address: %s", clientName));
    }
}
